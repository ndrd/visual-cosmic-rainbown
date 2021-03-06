package mx.unam.ciencias.cv.core.geometry;

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

/**
* Deals with the transformation matrix, takes the params to
* make an apropiete matrix
*/
import mx.unam.ciencias.cv.utils.models.Matrix;
import mx.unam.ciencias.cv.utils.models.HCoords;

public class Transform {

	/** 
	* Translation matrix
	* takes a delta in (x,y) an build a new matrix with the parameters
	* returns a @link {Transformation2D} ready to use.
	*/
	public static Transformation2D translate (double deltaX, double deltaY) {
		double [][] matrix = { 
							{1, 0, deltaX},
                       	   	{0, 1, deltaY},
                       	   	{0, 0, 1}
                       	   };
		return new Transformation2D(new Matrix(matrix));
	}

	/**
	* Scales a vector in two factors x and y
	*/
	public static Transformation2D scale(double xFactor, double yFactor) {
		double [][] matrix = { 
							{xFactor, 	0, 		0},
                       	   	{0,		 yFactor,	 0},
                       	   	{0,			 0,		 1}
                       	   };
		return new Transformation2D(new Matrix(matrix));
	}

	/**
	* Apply the 2D-rotatation matrix 
	*/
	public static Transformation2D rotate(double tetha) {
		double [][] matrix = { 
							{ Math.cos(tetha), Math.sin(tetha), 0},
                       	   	{ -Math.sin(tetha), Math.cos(tetha), 0},
                       	   	{ 0,				 0, 			1}
                       	   };
		return new Transformation2D(new Matrix(matrix));
	}

	/**
	* Euclidean transformation
	* Rotation and translation
	*/
	public static Transformation2D euclidean(double tetha, double deltaX, double deltaY) {
		double [][] matrix = { 
							{ Math.cos(tetha), Math.sin(tetha), deltaX},
                       	   	{ -Math.sin(tetha), Math.cos(tetha), deltaY},
                       	   	{ 0,				 0, 			1}
                       	   };
		return new Transformation2D(new Matrix(matrix));
	}

	/**
	* Similarity transformation
	* Takes and scalar, rotate, and translate a vector
	*/
	public static Transformation2D similarity(double s, double tetha, double deltaX, double deltaY) {
		Transformation2D euclidean = Transform.euclidean(tetha, deltaX, deltaY);
		Matrix kernel = euclidean.getKernel();
		return new Transformation2D(Matrix.scalarMultiply(kernel, s));
	}

	/**
	* Affine Transformation, a free 2x3 matrix
	*/
	public static Transformation2D affine(double a, double b, double c,
										  double d, double e, double f) {
		double [][] matrix = { 
							{ a, b, c},
                       	   	{ d, e, f},
                       	   };
		return new Transformation2D(new Matrix(matrix));
	}

	/**
	* Affine Transformation, a free 2x3 matrix
	*/
	public static Transformation2D projective(double a, double b, double c,
										  	double d, double e, double f,
										  	double g, double h, double i) {
		double [][] matrix = { 
							{ a, b, c},
                       	   	{ d, e, f},
                       	   	{ g, h, i}
                       	   };
		return new Transformation2D(new Matrix(matrix));
	}


}
