package com.github.danice123.hardCicleSplitter;

import java.util.Collection;

import com.google.common.collect.Lists;

public class ExtremesFinder {
	
	private Coord minX = null;
	private Coord maxX = null;
	private Coord minY = null;
	private Coord maxY = null;

	public ExtremesFinder(Collection<Coord> coords) {
		for (Coord coord : coords) {
			if (maxX == null || coord.x > maxX.x) {
				maxX = coord;
			}
			if (minX == null || coord.x < minX.x) {
				minX = coord;
			}
			if (maxY == null || coord.y > maxY.y) {
				maxY = coord;
			}
			if (minY == null || coord.y < minY.y) {
				minY = coord;
			}
		}
	}

	public Coord getMinX() {
		return minX;
	}
	
	public double getMinXValue() {
		return minX.x;
	}

	public Coord getMaxX() {
		return maxX;
	}
	
	public double getMaxXValue() {
		return maxX.x;
	}

	public Coord getMinY() {
		return minY;
	}
	
	public double getMinYValue() {
		return minY.y;
	}

	public Coord getMaxY() {
		return maxY;
	}
	
	public double getMaxYValue() {
		return maxY.y;
	}
	
	public Collection<Coord> getExtremes() {
		return Lists.newArrayList(minX, maxX, minY, maxY);
	}

}
