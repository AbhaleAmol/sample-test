package com.jalbum.util;

import com.jalbum.delegate.GalleryDelegate;

public class DatabaseImageService implements ImageService {

	private GalleryDelegate galleryDelegate;
	
	public DatabaseImageService() {
		galleryDelegate = new GalleryDelegate();
	}

	@Override
	public byte[] getImageContent(Integer imageID) {
		return galleryDelegate.getImageContent(imageID);
	}
}
