package com.jdk5.blog.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Utils {
	public static BufferedImage createImage(BufferedImage img, int width,
			int height, Color bgcolor) {
		int type = BufferedImage.TYPE_INT_ARGB;
		BufferedImage newImage = new BufferedImage(width, height, type);
		
    	Graphics2D g = newImage.createGraphics();
    	setRenderingHint(g);
    	if (bgcolor != null) {
    		g.setPaint(bgcolor);
    		g.fillRect(0, 0, width, width);
		}
		g.drawImage(img, 0, 0, width, height, null);
		g.dispose();
		return newImage;
    }
	
	public static void setRenderingHint(Graphics2D g){
		Map<RenderingHints.Key, Object> m = new HashMap<RenderingHints.Key, Object>();
		m.put(RenderingHints.KEY_INTERPOLATION, 
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		m.put(RenderingHints.KEY_ALPHA_INTERPOLATION , 
				RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		m.put(RenderingHints.KEY_COLOR_RENDERING , RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		m.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		m.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		m.put(RenderingHints.KEY_DITHERING , RenderingHints.VALUE_DITHER_ENABLE);
		/*
		m.put(RenderingHints. , RenderingHints.);
		*/
		g.setRenderingHints(m);
	}
}
