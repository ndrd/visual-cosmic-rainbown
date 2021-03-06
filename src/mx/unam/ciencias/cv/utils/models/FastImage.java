package mx.unam.ciencias.cv.utils.models;
/*
 * This file is part of visual-cosmic-rainbown
 *
 * Copyright Jonathan Andrade 2015 <ndrd@ciencias.unam.mx>
 *
 * visual-cosmic-rainbown is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * visual-cosmic-rainbown is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with visual-cosmic-rainbown. If not, see <http://www.gnu.org/licenses/>.
 */
import java.awt.image.*;
import java.io.ByteArrayInputStream;

/**
* This class works with the byte array representation of a image of the
* @link {BufferedImage}, and makes faster manipulation of the pixels
* avoiding multiple heap stages, also working with Short type to improve 
* performance against Integer. 
*/
public class FastImage {

	private BufferedImage original;
	private byte [] pixels;
	protected int width;
	protected int height;
	protected int type;

	public FastImage(BufferedImage img) {
		original =  deepCopy(img);
		width = img.getWidth();
		height =  img.getHeight();
		type = img.getType();
		pixels =  ((DataBufferByte) original.getRaster().getDataBuffer()).getData();
	}

	public FastImage(FastImage img) {
		if (img == null)
			throw new IllegalArgumentException();

		width = img.width;
		height =  img.height;
		type = img.type;
		pixels = new byte[img.pixels.length];
		for (int i = 0; i < img.pixels.length; pixels[i] = img.pixels[i++]);
	}



	public FastImage(int width, int height, int type ) {
		this.width = width;
		this.height =  height;
		this.type = type;
		original = new BufferedImage(width, height, type);
		pixels = ((DataBufferByte) original.getRaster().getDataBuffer()).getData();
	}

	public short[] getPixel(int x, int y) {
		if ( x < 0 || x > width || y  < 0 || y > height)
			throw new IllegalArgumentException("Invalid Coordinates");

		short [] rgb = new short[3];
		int index = 3*(y * width + x);
		rgb[0] = pixels[index + 2];
		rgb[1] = pixels[index + 1];
		rgb[2] = pixels[index + 0];
		/* Masked for get the first 8 bit value */
		rgb[0] &= 0xff;
		rgb[1] &= 0xff;
		rgb[2] &= 0xff;

		return rgb;
	}

	public int[] getPixeli(int x, int y) {
		if ( x < 0 || x > width || y  < 0 || y > height)
			throw new IllegalArgumentException("Invalid Coordinates");

		int [] rgb = new int[3];
		int index = 3*(y * width + x);
		rgb[0] = pixels[index + 2];
		rgb[1] = pixels[index + 1];
		rgb[2] = pixels[index + 0];
		/* Masked for get the first 8 bit value */
		rgb[0] &= 0x000000FF;
		rgb[1] &= 0x000000FF;
		rgb[2] &= 0x000000FF;

		return rgb;
	}

	public void setPixel(int x, int y, short [] rgb) {
		if ( x < 0 || x > width || y  < 0 || y > height)
			throw new IllegalArgumentException("Invalid Coordinates");
		int index = 3 * (y * width  + x);
		pixels[index + 2] = (byte) (((int) rgb[0]) & 0xFF);
		pixels[index + 1] = (byte) (((int) rgb[1]) & 0xFF);
		pixels[index + 0] = (byte) (((int) rgb[2]) & 0xFF);
	}

	public void setPixel(int x, int y, int [] rgb) {
		if ( x < 0 || x > width || y  < 0 || y > height)
			throw new IllegalArgumentException("Invalid Coordinates");
		int index = 3 * (y * width  + x);
		pixels[index + 2] = (byte) (((int) rgb[0]) & 0xFF);
		pixels[index + 1] = (byte) (((int) rgb[1]) & 0xFF);
		pixels[index + 0] = (byte) (((int) rgb[2]) & 0xFF);
	}

	public void setPixel(int x, int y, double [] rgb) {
		if ( x < 0 || x > width || y  < 0 || y > height)
			throw new IllegalArgumentException("Invalid Coordinates");
		int index = 3 * (y * width  + x);
		pixels[index + 2] = (byte) (((int) rgb[0]) & 0xFF);
		pixels[index + 1] = (byte) (((int) rgb[1]) & 0xFF);
		pixels[index + 0] = (byte) (((int) rgb[2]) & 0xFF);
	}

	public void setPixel(int x, int y, float [] rgb) {
		if ( x < 0 || x > width || y  < 0 || y > height)
			throw new IllegalArgumentException("Invalid Coordinates");
		int index = 3 * (y * width  + x);
		pixels[index + 2] = (byte) (((int) rgb[0]) & 0xFF);
		pixels[index + 1] = (byte) (((int) rgb[1]) & 0xFF);
		pixels[index + 0] = (byte) (((int) rgb[2]) & 0xFF);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getType() {
		return type;
	}

	public BufferedImage getImage() {
		return original;
	}

	static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

}
