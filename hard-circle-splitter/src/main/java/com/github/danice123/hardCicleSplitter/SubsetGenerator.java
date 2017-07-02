package com.github.danice123.hardCicleSplitter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.math3.util.Combinations;

import com.google.common.collect.Lists;

public class SubsetGenerator {
	
	private List<Coord> coords;
	private int size;
	
	public SubsetGenerator(Collection<Coord> coords) {
		this.coords = Lists.newArrayList(coords);
		size = coords.size() / 2;
	}
	
	public Collection<Subset> generateHalfCollectionSubsets() {
		Combinations combinations = new Combinations(coords.size(), size);
		
		Collection<Subset> output = Lists.newArrayList();
		Iterator<int[]> iterator = combinations.iterator();
		while(iterator.hasNext()) {
			int[] next = iterator.next();
			output.add(generateSubset(next));
		}
		return output;
	}

	private Subset generateSubset(int[] indexes) {
		Collection<Coord> subset = Lists.newArrayList();
		for (int index : indexes) {
			subset.add(coords.get(index));
		}
		return new Subset(subset);
	}
	
//	public Collection<Subset> generateHalfCollectionSubsets() {
//	Collection<Subset> output = Lists.newArrayList();
//	
//	int[] indexes = new int[size];
//	for (int i = 0; i < size; i++) {
//		indexes[i] = i;
//	}
//	output.add(generateSubset(indexes));
//	
//	while(true) {
//		int i;
//		for (i = size - 1; i >= 0 && indexes[i] == size + i; i--);
//		if (i < 0) {
//			break;
//		}
//		
//		indexes[i]++;
//		for (++i; i < size; i++) {
//			indexes[i] = indexes[i - 1] + 1;
//		}
//		output.add(generateSubset(indexes));
//	}
//	return output;
//}

}
