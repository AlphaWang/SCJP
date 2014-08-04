//
/////////////////////////////////////////////////////////////////
//                 C O P Y R I G H T  (c) 2014
//             A G F A - G E V A E R T  G R O U P
//                    All Rights Reserved
/////////////////////////////////////////////////////////////////
//
//       THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
//                    Agfa-Gevaert Group
//      The copyright notice above does not evidence any
//     actual or intended publication of such source code.
//
/////////////////////////////////////////////////////////////////
//
//
package mvc.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.google.common.base.Objects;

public class FunctionIcon {

	
	private static Set<FunctionIcon> customIcons = new HashSet<FunctionIcon>();
	
	public static Set<FunctionIcon> getCustomIcons() {
		return Collections.unmodifiableSet(customIcons);
	}
	
	public static final int BUTTON_ICON_SIZE = 24;
	public static final int LINK_ICON_SIZE = 16;
	
	private String name;
	private String path;
	private byte[] iconBytes;
	private ImageIcon icon;
	
	public static FunctionIcon newCustomIcon(File file) {
		return newCustomIcon(imageFileToBytes(file, LINK_ICON_SIZE));
	}
	
	public static FunctionIcon newCustomIcon(byte[] bytes) {
		FunctionIcon icon = new FunctionIcon(null, null, bytes);
		cacheCustomIcon(icon);
		return icon;
	}
	
	public static void cacheCustomIcon(FunctionIcon icon) {
		customIcons.add(icon);
	}
	
	private FunctionIcon(String name, String path) {
		this(name, path, null);
	}
	
	private FunctionIcon(String name, String path, byte[] bytes) {
		this.name = name;
		this.path = path;
		this.iconBytes = bytes;
		if (this.getPath() != null) {
			this.icon = null;
		} else if (iconBytes != null) {
			this.icon = new ImageIcon(iconBytes);
			
			//resize image
//			Image img = icon.getImage();
//			int wideth = img.getWidth(null);
//			int height = img.getHeight(null);
//			BufferedImage tag = new BufferedImage(17, 17, BufferedImage.TYPE_INT_RGB);
//			tag.getGraphics().drawImage(img, 0, 0, 17, 17, null);
//			icon = new ImageIcon(tag);
//			iconBytes = fileToByte(new File(icon));
		}
	}
	public ImageIcon getIcon() {
		return icon;
	}
	
	public String getName() {
		return name;
	}
	public String getPath() {
		return path;
	}
	public byte[] getIconBytes() {
		return iconBytes;
	}
	
	
	private static byte[] imageFileToBytes(File file, int maxSize) {
		ImageIcon icon = new ImageIcon(file.getAbsolutePath());
		String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1); //$NON-NLS-1$
		int width = icon.getIconWidth();
		int height = icon.getIconHeight();
		if (width >= height) {
			if (width > maxSize) {
				height = (int) (height * maxSize / width);
				width = maxSize;
			}
		} else {
			if (height > maxSize) {
				width = width * maxSize / height;
				height = maxSize;
			}
		}
		Image image = icon.getImage();
		BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics bg = bImage.getGraphics();
		bg.drawImage(image, 0, 0, width, height, null);
		bg.dispose();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(bImage, suffix, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toByteArray();
	}
	
//	public static byte[] fileToByte(File sourceFile) {
//	  if (sourceFile.isFile() && sourceFile.exists()) {
//		 long fileLength = sourceFile.length();
//		 if (fileLength <= 0L) {
//			 return null;
//		 }
//		 try {
//			 BufferedInputStream fis = new BufferedInputStream(new FileInputStream(sourceFile));
//			 byte[] b = new byte[(int) fileLength];
//			 while (fis.read(b) != -1) {
//			 }
//			 fis.close();
//			 fis = null;
//			 return b;
//	    } catch (IOException e) {
//	    	e.printStackTrace();
//	    }
//	  }
//	  return null;
//	}

	@Override
	public int hashCode() {
		if (this.path != null) {
			return this.path.hashCode();
		}
		if (this.iconBytes != null) {
			return Arrays.hashCode(iconBytes);
		}
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof FunctionIcon)) {
			return false;
		}
		FunctionIcon icon  = (FunctionIcon) obj;
		if (icon.path != null && this.path != null) { //system icon
			return Objects.equal(icon.path, this.path);
		} else if (icon.path == null && this.path == null) { //custom icon
			return Arrays.equals(icon.iconBytes, this.iconBytes);
		}
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		if (this.path != null) {
			return this.path;
		}
		if (this.iconBytes != null) {
			return Arrays.toString(iconBytes);
		}
		return super.toString();
	}
}
