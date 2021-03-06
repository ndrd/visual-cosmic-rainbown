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

import mx.unam.ciencias.cv.utils.models.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class HoughTrasform extends Detector {

	public static class HoughParams  {

		int maxRange;

		public HoughParams() {
			int maxRange = 50;
		}
	}

	public static BufferedImage detect(BufferedImage img, HoughParams hp) {
		return img;
	}

	public static HoughParams defaultParams() {
		return new HoughParams();
	}
	
}