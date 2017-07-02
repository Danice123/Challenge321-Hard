package com.github.danice123.hardCicleSplitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

import com.google.common.collect.Lists;

public class InputReader {
	
	public Collection<Coord> readFile(BufferedReader input) {
		try {
			return readFileInternal(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Collection<Coord> readFileInternal(BufferedReader input) throws NumberFormatException, IOException {
		int numPoints = Integer.parseInt(input.readLine());
		
		Collection<Coord> list = Lists.newArrayList();
		for (int i = 0; i < numPoints; i++) {
			String line = input.readLine();
			String[] split = line.split(" ");
			Coord coord = new Coord(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
			list.add(coord);
		}
		return list;
	}

}
