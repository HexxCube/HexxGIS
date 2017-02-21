package org.italia.map;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Map {
	
	private BufferedImage image;
	
	Map(String file) {
		try {
			image = ImageIO.read(new File(file));
			parseImage();
		} catch (IOException e) {
			System.out.println("Error: Invalid image file.");
		}
	}
	
	private List<ArrayList<Integer>> parseImage() {
		ArrayList<ArrayList<Integer>> vert = new ArrayList<>();
		boolean flag = false;
		
		for (int j = 0; j < image.getHeight(); j++) {
			for (int i = 0; i < image.getWidth(); i++) {
				ArrayList<Integer> coord = new ArrayList<Integer>(); coord.add(i); coord.add(j);
				int pixel = image.getRGB(i, j);
				if (pixel >> 24 != 0) {
					if (flag) {
						continue;
					}
					flag = true;
				} else if (flag) {
					vert.add(coord);
					flag = false;
				}
			}
		}
		
		System.out.println(vert);
		return vert;
	}
	
}
