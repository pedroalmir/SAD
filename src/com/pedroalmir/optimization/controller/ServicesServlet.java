package com.pedroalmir.optimization.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import au.com.bytecode.opencsv.CSVReader;

import com.pedroalmir.optimization.model.domain.Animal;
import com.pedroalmir.optimization.model.domain.InputModel;
import com.pedroalmir.optimization.model.domain.enuns.SexoEnum;
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
				InputModel model = HttpRequestMultipart.processRequest(request);
				ArrayList<Animal> animais = getAnimais(model.getData());
				
				System.out.println(model);
				
				dispatcher = request.getRequestDispatcher("index.jsp");
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
				parameters.put("peso", Double.parseDouble(list.get(i)[6]));
				if(list.get(i)[7].equals("mort")){
					parameters.put("vivo", false);
				}else{
					parameters.put("sexo", true);
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
