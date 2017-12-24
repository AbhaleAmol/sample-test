package com.jalbum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jalbum.delegate.GalleryDelegate;

public class GalleryServlet extends HttpServlet {

	private GalleryDelegate galleryDelegate;
	
	@Override
	public void init() throws ServletException {
		galleryDelegate = new GalleryDelegate();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentAction = request.getParameter("action");
		Integer targetImageID = null;
		Integer currentImageID = null;
		
		if(currentAction == null || currentAction.length() <= 0) {
			targetImageID = galleryDelegate.getFirstImageID();
		} else if("next".equals(currentAction)) {
			currentImageID = Integer.parseInt(request.getParameter("image_id"));
			targetImageID = galleryDelegate.getNextImageID(currentImageID);
		} else if("prev".equals(currentAction)) {
			currentImageID = Integer.parseInt(request.getParameter("image_id"));
			targetImageID = galleryDelegate.getPreviousImageID(currentImageID);
		}
		
		if(targetImageID == null || targetImageID == 0) {
			targetImageID = currentImageID;
		}
		
		request.setAttribute("image_id", targetImageID);
		request.getRequestDispatcher("/WEB-INF/view/Gallery.jsp").forward(request, response);
	}
}
