package com.github.danice123.hardCicleSplitter;

import java.util.Collection;

import com.google.common.collect.Lists;

public class CoordProcessor {
	
	private Collection<Coord> coords;

	public CoordProcessor(Collection<Coord> coords) {
		this.coords = coords;
	}
	
	public Subset findBestSubset() {
		Collection<Subset> subsets = new SubsetGenerator(coords).generateHalfCollectionSubsets();
		
		Collection<Subset> validSubsets = Lists.newArrayList();
		for (Subset subset : subsets) {
			if (isSubsetValid(subset)) {
				validSubsets.add(subset);
			}
		}
		
		Subset bestSubset = null;
		for (Subset subset : validSubsets) {
			if (bestSubset == null || bestSubset.getRadius() > subset.getRadius()) {
				bestSubset = subset;
			}
		}
		
		return bestSubset;
	}
	
	private boolean isSubsetValid(Subset subset) {
		for (Coord coord : coords) {
			if (!subset.getSubsets().contains(coord) && subset.isPointInSubsetCircle(coord)) {
				return false;
			}
		}
		return true;
	}

}
