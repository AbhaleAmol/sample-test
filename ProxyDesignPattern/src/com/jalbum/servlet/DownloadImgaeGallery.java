package com.jalbum.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jalbum.util.ImageService;
import com.jalbum.util.ImageServiceFactory;

public class DownloadImgaeGallery extends HttpServlet {

	private ImageService imageService;
	
	@Override
	public void init() throws ServletException {
		imageService = ImageServiceFactory.getImageService("cache");
	}



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer imageID = Integer.parseInt(request.getParameter("image_id"));
		
		byte[] imageContent = imageService.getImageContent(imageID);
		
		response.setContentType("image/jpeg");
		response.setHeader("Content-Disposition", "inline");
		
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(imageContent);
		outputStream.close();
	}
}
