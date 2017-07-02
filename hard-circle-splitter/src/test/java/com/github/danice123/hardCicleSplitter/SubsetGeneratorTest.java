package com.github.danice123.hardCicleSplitter;

import java.util.Collection;

import org.junit.Test;

import com.google.common.collect.Lists;

public class SubsetGeneratorTest {

	@Test
	public void test() {
		Collection<Coord> list = Lists.newArrayList(new Coord(1, 2), new Coord(3, 4), new Coord(5, 6), new Coord(7, 8));
		
		SubsetGenerator subsetGenerator = new SubsetGenerator(list);
		
		Collection<Subset> generateHalfCollectionSubsets = subsetGenerator.generateHalfCollectionSubsets();
		
		for (Subset subset : generateHalfCollectionSubsets) {
			System.out.println(subset.getSubsets());
		}
	}

}
