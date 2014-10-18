package com.pedroalmir.optimization.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.Years;

import au.com.bytecode.opencsv.CSVReader;

import com.pedroalmir.optimization.algorithm.genetic.gGA.GGAAlgorithm;
import com.pedroalmir.optimization.model.algorithm.solution.AnimalSelectionSolution;
import com.pedroalmir.optimization.model.domain.Animal;
import com.pedroalmir.optimization.model.domain.InputModel;
import com.pedroalmir.optimization.model.domain.enuns.SexoEnum;
import com.pedroalmir.optimization.model.vo.solution.AnimalSelectionSolutionVO;
import com.pedroalmir.optimization.util.HttpRequestMultipart;

/**
 * KnapsackProblemServlet
 * @author Pedro Almir
 */
@SuppressWarnings("serial")
public class ServicesServlet extends HttpServlet {
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("optimization.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		try {
			/* Check that we have a file upload request */
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart){
				/* Process multipart request */
				InputModel model = HttpRequestMultipart.processRequest(request);
				
				/* Obtem a lista de animais do arquivo */
				ArrayList<Animal> animais = getAnimais(model.getData());
				ArrayList<Animal> animaisAptos = new ArrayList<Animal>();
				
				/* Get a DescriptiveStatistics instance */
				DescriptiveStatistics stats = new DescriptiveStatistics();
				
				/* Contabilizando a quantidade de machos e femeas */
				int qntMachos = 0, qntFemeas = 0;
				for(Animal animal : animais){
					animal.setIdadeAtualAnos(Years.yearsBetween(new DateTime(animal.getDataNascimento()), new DateTime(new Date())).getYears());
					int idade = Months.monthsBetween(new DateTime(animal.getDataNascimento()), new DateTime(new Date())).getMonths(); 
					if(animal.getSexo().equals(SexoEnum.MACHO) && idade >= model.getIdadeAcasalamentoMachos() && animal.isVivo()){
						animal.setAptoAcasalamento(true);
						stats.addValue(animal.getPeso());
						qntMachos++; animaisAptos.add(animal);
					}else if(animal.getSexo().equals(SexoEnum.FEMEA) && idade >= model.getIdadeAcasalamentoFemeas() && animal.isVivo()){
						animal.setAptoAcasalamento(true);
						stats.addValue(animal.getPeso());
						qntFemeas++; animaisAptos.add(animal);
					}
				}
				
				/* Calculando a média e desvio padrão da característica (peso) */
				model.setMediaCaracteristica(stats.getMean());
				model.setDesvioPadraoCaracteristica(stats.getStandardDeviation());
				
				/* Percentual de machos/femeas: quantidade percentual de seleção de machos/femeas dividido pelo total de machos/femeas. */
				double percentualMachos = (Math.floor(qntMachos*model.getPercentualMachos()))/qntMachos;
				double percentualFemeas = (Math.floor(qntFemeas*model.getPercentualFemeas()))/qntFemeas;
				
				/* Formatando o percentual de machos e fêmas */
				DecimalFormat fmt = new DecimalFormat("0.0000");
				percentualMachos = Double.parseDouble(fmt.format(percentualMachos).replace(",", "."));
				percentualFemeas = Double.parseDouble(fmt.format(percentualFemeas).replace(",", "."));
				
				model.calcIntensidadeSelecao(percentualMachos, SexoEnum.MACHO);
				model.calcIntensidadeSelecao(percentualFemeas, SexoEnum.FEMEA);
				
				/* Definindo a quantidade máxima de machos */
				int qntFemeasPorMacho = (int) Math.floor(1/model.getProporcaoMachoFemea());
				
				int qntMaxMachos = ((int) Math.floor(qntFemeas*model.getPercentualFemeas()))/qntFemeasPorMacho;
				int qntMaxFemeas = ((int) Math.floor(qntFemeas*model.getPercentualFemeas()));
				
				if(qntMaxMachos > qntMachos){
					qntMaxMachos = qntMachos;
					qntMaxFemeas = qntMachos * qntFemeasPorMacho;
					
					System.err.println("Erro: O número de machos é insuficiente para a quantidade de fêmeas");
					System.err.println("Erro: Apenas " + qntMaxFemeas + " fêmeas serão selecionadas.");
					System.err.println("Erro: Há uma proporção de 1 Macho para " + qntFemeasPorMacho + " fêmea(s). "
							+ "Machos: " + ((int) Math.floor(qntMachos*model.getPercentualMachos())) + " - "
							+ "Fêmeas: " + ((int) Math.floor(qntFemeas*model.getPercentualFemeas())));
				}
				
				/* Primeira fase: seleção dos melhores animais */
				GGAAlgorithm algorithm = new GGAAlgorithm(model, animaisAptos, qntMaxMachos, qntMaxFemeas);
				
				ArrayList<AnimalSelectionSolution> results = algorithm.solveProblem();
				System.out.println(results.get(0));
				
				ArrayList<AnimalSelectionSolutionVO> melhoresResultados = new ArrayList<AnimalSelectionSolutionVO>();
				int size = (results.size() >= 3) ? 3 : results.size();
				for(int i = 0; i < size; i++){
					melhoresResultados.add(new AnimalSelectionSolutionVO((i+1), results.get(i).getGanhoGenetico(), results.get(i).getAnimaisSelecionados()));
				}
				
				request.setAttribute("showResultPanel", true);
				request.setAttribute("results", melhoresResultados);
				
				dispatcher = request.getRequestDispatcher("optimization.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @param data
	 * @return
	 */
	private ArrayList<Animal> getAnimais(byte[] data) {
		ArrayList<Animal> animais = new ArrayList<Animal>();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			CSVReader reader = new CSVReader(new InputStreamReader(new ByteArrayInputStream(data)), ';');
			List<String[]> list = reader.readAll();
			HashMap<String, Object> parameters = null;
			
			for(int i = 1; i < list.size(); i++){
				parameters = new HashMap<String, Object>();
				parameters.put("idAnimal", Long.valueOf(list.get(i)[0]));
				parameters.put("idPai", Long.valueOf(list.get(i)[1]));
				parameters.put("idMae", Long.valueOf(list.get(i)[2]));
				parameters.put("dataNascimento", formatter.parse(list.get(i)[3]));
				if(list.get(i)[4].equals("F")){
					parameters.put("sexo", SexoEnum.FEMEA);
				}else{
					parameters.put("sexo", SexoEnum.MACHO);
				}
				parameters.put("dataColeta", formatter.parse(list.get(i)[5]));
				parameters.put("peso", Double.parseDouble(list.get(i)[6].replace(",", ".")));
				if(list.get(i)[7].equals("mort")){
					parameters.put("vivo", false);
				}else{
					parameters.put("vivo", true);
				}
				animais.add(new Animal(parameters));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return animais;
	}
}
