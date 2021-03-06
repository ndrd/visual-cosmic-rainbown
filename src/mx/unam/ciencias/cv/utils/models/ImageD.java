package mx.unam.ciencias.cv.utils.models;
/*
 * This file is part of visual-cosmic-rainbown
 *
 * Jonathan Andrade 2015
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

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class ImageD extends FastImage implements java.io.Serializable {
	/**
	* Use to store the rgb kindly 
	*/
	public class RGB implements java.io.Serializable  {
		
		double r;
		double g;
		double b;
		private final double  RATIO = (1/3);

		public RGB (double r, double g, double b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}

		public double grayScaleValue() {
			return (r + g + b) * RATIO;
		}

		@Override public String toString() {
			return "RGB: (" + r + ", " + g  + ", " + b + ")"; 
		}

	}

	private Histogram red;
	private Histogram green;
	private Histogram blue;
	private Histogram grayScale;
	private RGB meanColor;
	private RGB meanGray;
	private RGB mins;
	private RGB maxs;
	private final int RGB_VALUES = 256;


	public ImageD (BufferedImage img) {
		super(img);
		red = new Histogram(RGB_VALUES);
		green = new Histogram(RGB_VALUES);
		blue = new Histogram(RGB_VALUES);
		grayScale = new Histogram(RGB_VALUES);

        short[] rgb = new short[3];
	    for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                rgb = getPixel(x, y);

                red.add(rgb[0]);
                green.add(rgb[1]);
                blue.add(rgb[2]);
                
            	int meanValue = (int)(rgb[0] + rgb[1] + rgb[2]) / 3;
            	grayScale.add(meanValue);
            }
        }

        meanColor = new RGB(red.getMeanValue(), green.getMeanValue(), blue.getMeanValue());
        meanGray = new RGB(grayScale.getMeanValue(), grayScale.getMeanValue(), grayScale.getMeanValue());
	}

	public Histogram getRedHistogram() {
		return red;
	}

	public Histogram getGreenHistogram() {
		return green;
	}

	public Histogram getBlueHistogram() {
		return blue;
	}

	public Histogram getGrayScaleHistogram() {
		return grayScale;
	}

	public int[] getMeanColor() {
		int[] rgb =  new int[3];
		rgb[0] = (int) meanColor.r;
		rgb[1] = (int) meanColor.g;
		rgb[2] = (int) meanColor.b;
		return rgb;
	}

	public void report() {
		p("Mean color: " + meanColor);
		p("R[min, max]: " + red.minValue + " , " + red.maxValue);
	}

	private void p(Object o) {
		System.out.println(o);
	}


	
	
}