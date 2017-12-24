package com.jalbum.util;

import java.util.List;
import java.util.Vector;

import com.jalbum.delegate.GalleryDelegate;

public class CachedImageService implements ImageService {

	private List<ImageHolder> images;
	private GalleryDelegate galleryDelegate;
	
	public CachedImageService() {
		images = new Vector<>();
		galleryDelegate = new GalleryDelegate();
	}

	@Override
	public byte[] getImageContent(Integer imageID) {
		
		byte[] imageContent = null;
		
		if(images.size() > 0) {
			for(ImageHolder cachedImageHolder : images) {
				if(imageID.equals(cachedImageHolder.getImageID())) {
					imageContent = cachedImageHolder.getImageContent();
					break;
				}
			}
		}
		
		if(imageContent == null || imageContent.length <= 0) {
			
			ImageHolder imageHolder = null;
			imageHolder = new ImageHolder();
			
			imageContent = galleryDelegate.getImageContent(imageID);
			
			imageHolder.setImageID(imageID);
			imageHolder.setImageContent(imageContent);
			images.add(imageHolder);
			
			if(images.size() > 3) {
				images.remove(0);
			}
		}
		
		return imageContent;
	}
}
