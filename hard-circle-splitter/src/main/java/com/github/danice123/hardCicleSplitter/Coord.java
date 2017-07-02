package com.github.danice123.hardCicleSplitter;

import java.util.UUID;

public class Coord {
	
	private UUID uniqueId;
	public double x = 0;
	public double y = 0;
	
	public Coord(double x, double y) {
		this.x = x;
		this.y = y;
		uniqueId = UUID.randomUUID();
	}
	
	public double distanceTo(Coord coord) {
		double xSq = (x - coord.x) * (x - coord.x);
		double ySq = (y - coord.y) * (y - coord.y);
		return Math.sqrt(xSq + ySq);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coord) {
			Coord other = (Coord) obj;
			return uniqueId.equals(other.uniqueId);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return uniqueId.hashCode();
	}

	@Override
	public String toString() {
		return x + ", " + y;
	}
}
