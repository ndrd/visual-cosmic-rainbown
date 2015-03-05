package mx.unam.ciencias.cv.test;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import mx.unam.ciencias.cv.utils.*;
import mx.unam.ciencias.cv.filters.*;
import org.junit.Assert;
import org.junit.Test;


public class ColorFiltersTest extends FiltersTest {

	public ColorFiltersTest() {
		super();
	}

	@Test public void histogramEqualizationTest() {
		try {
			long total = 0;
			for (int i = 0; i < ITERS ; i++) {
				long startTime = System.nanoTime();
				ColorFilters.histogramEqualization(img);
				long endTime = System.nanoTime();
				total += (endTime - startTime);
			}
		    System.out.println(String.format( ITERS  + " iters for histogramEqualizationTest, total time %s", SpeedTest.timeFormat(total)));
			System.out.println();
			System.out.println();
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test public void grayScaleTest() {
		try {
			long total = 0;
			for (int i = 0; i < ITERS ; i++) {
				long startTime = System.nanoTime();
				ColorFilters.grayScale(img);
				long endTime = System.nanoTime();
				total += (endTime - startTime);
			}
		    System.out.println(String.format( ITERS  + " iters for histogramEqualizationTest, total time %s", SpeedTest.timeFormat(total)));
			System.out.println();
			System.out.println();
		} catch (Exception e) {
			Assert.fail();
		}
	}
}