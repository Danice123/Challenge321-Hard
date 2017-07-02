package com.github.danice123.hardCicleSplitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader reader = openFile();
		Collection<Coord> coords = new InputReader().readFile(reader);
		CoordProcessor coordProcessor = new CoordProcessor(coords);
		
		Subset findBestSubset = coordProcessor.findBestSubset();
		
		if (findBestSubset != null) {
			System.out.println(findBestSubset.getCenterOfSubset());
			System.out.println(findBestSubset.getRadius());
		} else {
			System.out.println("No solution");
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static BufferedReader openFile() {
		BufferedReader bufferedReader = null;
		try {
			File inputFile = new File("input.txt");
			inputFile.createNewFile();
			bufferedReader = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bufferedReader;
	}

}
