package com.jalbum.delegate;

import com.jalbum.dao.GalleryDao;

public class GalleryDelegate {

	private GalleryDao galleryDao;
	
	public GalleryDelegate() {
		galleryDao = new GalleryDao();
	}
	
	public Integer getFirstImageID() {
		return galleryDao.getFirstImageID();
	}
	
	public Integer getNextImageID(Integer currentImageID) {
		return galleryDao.getNextImageID(currentImageID);
	}
	
	public Integer getPreviousImageID(Integer currentImageID) {
		return galleryDao.getPreviousImageID(currentImageID);
	}
	
	public byte[] getImageContent(Integer imageID) {
		return galleryDao.getImageContent(imageID);
	}
}
