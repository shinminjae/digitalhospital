package kr.bit.digitalhsp.mapping.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;


public class CanvasComposit extends Canvas {

	private ImageRegistry ir = new ImageRegistry();
	private List<String> imgageRegistryKeys;
	private String mainImageKey;
	private String dirPath = "D:\\Developer\\JAVA\\Project\\SPRING\\workspace\\Mapping_Service\\src\\property\\image\\";
	
	public ImageRegistry getIr() {
		return ir;
	}

	public void setIr(ImageRegistry ir) {
		this.ir = ir;
	}

	public String getMainImage() {
		return mainImageKey;
	}

	public void setMainImage(String key) {
		this.mainImageKey = key;
		redraw();
	}

	/**
	 * 
	 * @param imgPath
	 * @return
	 */
	public void addPicture(String key, String imgPath) {

		try {

			ImageDescriptor id = ImageDescriptor.createFromFile(null, dirPath
					+ imgPath);
			this.imgageRegistryKeys.add(key);
			this.ir.put(key, id);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public int findImageRegistryKeyIndex(String key) {
		for (int i = 0; i < this.imgageRegistryKeys.size(); i++) {
			String tempkey = this.imgageRegistryKeys.get(i);
			if (tempkey.equals(key)) {
				return i;
			}
		}

		return -1;
	}

	public void deleteImageRegistryKey(String key) {
		int index = this.findImageRegistryKeyIndex(key);
		this.imgageRegistryKeys.remove(index);
	}

	public void deleteAllPicture() {
		for (String key : this.imgageRegistryKeys) {
			deletePicture(key);
		}

	}

	/**
	 * 
	 * @param imgPath
	 * @return
	 */
	public void deletePicture(String key) {

		try {

			this.ir.remove(key);
			this.deleteImageRegistryKey(key);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Image getImage(String key) {
		return ir.get(key);
	}

	public CanvasComposit(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
		imgageRegistryKeys = new ArrayList<String>();
		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent pe) {
				// TODO Auto-generated method stub

				// Display disp = pe.display;
				GC gc = pe.gc;
				Image image = ir.get(mainImageKey);

				// ImageData imageData = image.getImageData().scaledTo(100,
				// 100);

				// image.getImageData().

				if (image != null) {
					gc.drawImage(image, 0, 0, image.getBounds().width,
							image.getBounds().height, 0, 0, 400, 400);
					// gc.drawImage(image, 10, 10);
				}

			}
		});

	}

}
