/**
 * 
 */
package com.pedroalmir.optimization.util;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.pedroalmir.optimization.model.domain.InputModel;
import com.pedroalmir.optimization.model.domain.enun.CaracteristicaEnum;
import com.pedroalmir.optimization.model.domain.enun.GrupoContemporaneosEnum;


/**
 * Http Request Multipart manager
 * @author Pedro Almir
 */
public class HttpRequestMultipart {

	/**
	 * Process request and create user with image
	 * 
	 * @param request
	 * @return model
	 */
	public static InputModel processRequest(HttpServletRequest request){
		InputModel model = new InputModel();
		String value = "";
		ServletFileUpload upload = new ServletFileUpload();
		FileItemIterator iter;

		try {
			iter = upload.getItemIterator(request);
			while (iter.hasNext()) {
				FileItemStream fileItem = iter.next();
				if (fileItem.isFormField()) {

					InputStream stream = fileItem.openStream();
					byte[] str = new byte[stream.available()];
					stream.read(str);
					value = new String(str, "UTF8");
					
					if(fileItem.getFieldName().equals("percentualMacho")){
						model.setPercentualMachos(Double.parseDouble(value.trim()));
					}else if(fileItem.getFieldName().equals("percentualFemea")){
						model.setPercentualFemeas(Double.parseDouble(value.trim()));
					}else if(fileItem.getFieldName().equals("idadeAcasalamentoMacho")){
						model.setIdadeAcasalamentoMachos(Integer.parseInt(value.trim()));
					}else if(fileItem.getFieldName().equals("idadeAcasalamentoFemea")){
						model.setIdadeAcasalamentoFemeas(Integer.parseInt(value.trim()));
					}else if(fileItem.getFieldName().equals("proporcaoMachoFemea")){
						model.setProporcaoMachoFemea(Double.parseDouble(value.trim()));
					}else if(fileItem.getFieldName().equals("herdabilidade")){
						model.setHerdabilidade(Double.parseDouble(value.trim()));
					}
					
					/* Inicialmente só trabalhamos com a caracteristica peso. */
					model.setCaracteristica(CaracteristicaEnum.PESO);
					/* Os grupos de contemporaneios serão formados apenas pelo ano e pelo sexo. */
					model.addGrupo(GrupoContemporaneosEnum.ANO);
					model.addGrupo(GrupoContemporaneosEnum.SEXO);
				} else {
					if(fileItem.getFieldName().equals("inputFile")){
						InputStream fileStream = fileItem.openStream();
						
						String fileName = fileItem.getName();
						String mime = fileItem.getContentType();
						byte[] byteArray = IOUtils.toByteArray(fileStream);
						
						model.setData(byteArray);
						model.setFileName(fileName);
						model.setMimeType(mime);
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return model;
	}

}
