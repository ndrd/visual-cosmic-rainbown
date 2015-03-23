package mx.unam.ciencias.cv.core.filters;
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

public abstract class ImageFilter {

	protected static int xSize;
	protected static int ySize;
	private static String name;


	public static int intersect(int d1, int d2) {
		return Math.max(d1,d2);
	}

	public static void debug(Object o) {
		System.out.println(o);
	}

	public static void setName(String a) {
		name = a;
	}

	public static String getName() {
		return name;
	}

	
}