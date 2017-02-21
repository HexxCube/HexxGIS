package org.italia.map;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the image file's location: ");
		String imageLoc = scanner.next();
		new Map(imageLoc);
	}
	
}
