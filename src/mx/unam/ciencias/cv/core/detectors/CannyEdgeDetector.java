package mx.unam.ciencias.cv.core.detectors;
/*
 * This file is part of visual-cosmic-rainbown
 *
 * Copyright Jonathan Andrade 2015
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
import mx.unam.ciencias.cv.utils.models.FastImage;
import mx.unam.ciencias.cv.core.miscellaneous.*;
import mx.unam.ciencias.cv.core.filters.*;


public class CannyEdgeDetector {

	private BufferedImage edges;
	private BufferedImage in;
	private static int INITIAL_SIGMA = 3;

	public static BufferedImage detect (BufferedImage in, int sigma, int gradientRadius) {

		int width = in.getWidth();
		int height = in.getHeight();

		in = ColorFilters.contrastEqualization(in);
		FastImage gScale  = GaussianBlur.gaussianBlur3(ColorFilters.grayScale(in), sigma);
		FastImage gx = GaussianBlur.gaussianVertical(gScale, sigma);
		FastImage gy = GaussianBlur.gaussianHorizontal(gScale, sigma);

		double[][] gradient  = new double[width][height];
		double[][] direction =  new double[width][height];

		short [] xg = new short[3];
		short [] yg = new short[3];

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++ ) {

				xg = gx.getPixel(x,y);
				yg = gy.getPixel(x,y);

				gradient[x][y] = Math.hypot(xg[0], yg[0]);
				/* the sign of the direction is irrelevant */
				direction[x][y] = Math.abs(Math.atan2(yg[0],xg[0]));
			}
		}

		boolean[][] maximus = nonMaximumSuppresion(gradient, direction, gradientRadius); 
		drawMaximum(gScale, maximus);
		return gScale.getImage();

	}

	static void drawMaximum(FastImage in, boolean [][] maximus) {
		
		int width = in.getWidth();
		int height = in.getHeight();
		
		short [] mark = {255,0,0};

		for (int x = 0; x < width ;x++ ) {
			for (int y = 0; y < height ; y++ ) {
				if (maximus[x][y])
					in.setPixel(x,y,mark);
			}
		}

	}

	static boolean[][] nonMaximumSuppresion(double[][] gradient, double[][] direction, int radius) {
		
		short[] rgb = new short[3];
		double slope = 0;
		double magnitude = 0;

		int width = direction.length;
		int height = direction[0].length;

		boolean [][] isMax = new boolean[width][height];

		for (int x = radius + 1; x < width - radius ;x++ ) {
			for (int y = radius + 1; y < height - radius ;y++ ) {
				
				boolean esMaximo = true;
				slope = Math.tan(direction[x][y]);
				magnitude = gradient[x][y];
				
				for (int r = -radius; r < radius && esMaximo; r++ ) {
					int nx = x+r;
					int ny = (int)(y+r*slope);
					if (pxInRange(width, height, nx, ny))
						esMaximo = (magnitude > gradient[nx][ny]);
					else
						System.out.println("No tin range");

				}

				if (esMaximo) {
					isMax[x][y] = esMaximo;	

				}

				
			}
		}
		return isMax;
	}

	static boolean pxInRange(int width, int height, int x, int y) { 
         return (x < width && y < height && x >= 0 && y >= 0);
    }





	void drawEdges(int data[], int width, int height) {
		edges = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		edges.getWritableTile(0, 0).setDataElements(0, 0, width, height, data);
	}

}