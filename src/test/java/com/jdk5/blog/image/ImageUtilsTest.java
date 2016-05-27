package com.jdk5.blog.image;

import java.awt.Color;
import java.io.File;

import junit.framework.TestCase;


public class ImageUtilsTest extends TestCase {

	public void test() {
		try {
			/*
			ImageUtils.fromFile(new File("d:\\image\\org.jpg"))
				.quality(0.7f)
				.fixedGivenSize(true)
				.keepRatio(true)
				.size(400, 100)
				.toFile(new File("d:\\image\\400_100_not_ratio.jpg"));
			
			ImageUtils.fromFile(new File("d:\\image\\org.jpg"))
				.quality(0.7f)
				.fixedGivenSize(true)
				.keepRatio(true)
				.size(200, 200)
				.toFile(new File("d:\\image\\200_200_not_ratio.jpg"));
						
			ImageUtils.fromFile(new File("d:\\image\\org.jpg"))
				.quality(0.7f)
				.keepRatio(true)
				.size(400, 100)
				.toFile(new File("d:\\image\\400_100_ratio.jpg"));
			
			ImageUtils.fromFile(new File("d:\\image\\org.jpg"))
				.quality(0.7f)
				.keepRatio(true)
				.size(200, 200)
				.toFile(new File("d:\\image\\200_200_ratio.jpg"));
			
			System.out.println(f.exists());
			
			ImageUtils.fromFile(f)
				.quality(0.7f)
				.width(700)
				.toFile(new File("d:\\image\\test.jpg"));
			*/
			String str = ImageUtilsTest.class.getResource("/org.jpg").getPath();
			File f = new File(str);
			
			ImageUtils.fromFile(f)
				//.width(200)
				//.height(200)
				//.scale(1)
				//.size(200, 22)
				.rotate(34)
				.quality(0.6f)
				.bgcolor(Color.BLUE)
				.toFile(new File("d:\\image\\test.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}