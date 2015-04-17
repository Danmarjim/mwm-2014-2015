package es.us.mwm;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;

@SuppressWarnings("serial")
public class ShowImagesServlet extends HttpServlet {
	
	private BlobstoreService bs = BlobstoreServiceFactory.getBlobstoreService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	
		List<BlobKey> blobs = bs.getUploads(req).get("My file");
		BlobKey bk = blobs.get(0);
		
		ImagesService imagesService	= ImagesServiceFactory.getImagesService();
		Image oldImage = ImagesServiceFactory.makeImageFromBlob(bk);
		Transform resize = ImagesServiceFactory.makeImFeelingLucky();
		Image newImage = imagesService.applyTransform(resize, oldImage);
		resp.setContentType("image/png");
		resp.getOutputStream().write(newImage.getImageData());
		
	}
}
