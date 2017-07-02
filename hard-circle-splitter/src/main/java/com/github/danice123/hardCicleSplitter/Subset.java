package com.github.danice123.hardCicleSplitter;

import java.util.Collection;

public class Subset {
	
	private Collection<Coord> coords;
	private ExtremesFinder extremes;
	
	private Coord center = null;
	private double radius = 0;
	
	public Subset(Collection<Coord> coords) {
		this.coords = coords;
		extremes = new ExtremesFinder(coords);
	}
	
	public Collection<Coord> getSubsets() {
		return coords;
	}
	
	public Coord getCenterOfSubset() {
		if (center == null) {
			double centerX = (extremes.getMaxXValue() + extremes.getMinXValue()) / 2.0;
			double centerY = (extremes.getMaxYValue() + extremes.getMinYValue()) / 2.0;
			center = new Coord(centerX, centerY);
		}
		return center;
	}
	
	public double getRadius() {
		if (radius == 0) {
			Coord center = getCenterOfSubset();
			for (Coord extreme : extremes.getExtremes()) {
				double distance = center.distanceTo(extreme);
				if (distance > radius) {
					radius = distance;
				}
			}
		}
		return radius;
	}
	
	public boolean isPointInSubsetCircle(Coord coord) {
		Coord centerOfSubset = getCenterOfSubset();
		
		if (centerOfSubset.distanceTo(coord) <= getRadius()) {
			return true;
		}
		return false;
	}
}
