package com.jalbum.util;

public class ImageServiceFactory {

	public static ImageService getImageService(String serviceType) {
		
		if("cache".equals(serviceType)) {
			return new CachedImageService();
		} else if("database".equals(serviceType)) {
			return new DatabaseImageService();
		}
		
		return new DatabaseImageService();
	}
}
