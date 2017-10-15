package pl.sda.sort.impl;

import pl.sda.sort.Sort;

public class CountSort implements Sort {

	@Override
	public int[] sort(int[] numbers) {
		int maxValue = 0;
		for (int value : numbers) {
			if (value > maxValue) {
				maxValue = value;
			}
		}
		
		if (maxValue > 0) {
			int[] counts = new int[maxValue + 1];
			for (int i = 0; i < counts.length; i++) {
				counts[i] = 0;
			}

			for (int value : numbers) {
				counts[value]++;
			}

			int resultArrayPos = 0;
			int[] resultArray = new int[numbers.length];
			for (int index = 0; index < counts.length; index++) {
				if (counts[index] > 0) {
					for (int i = 0; i < counts[index]; i++) {
						resultArray[resultArrayPos] = index;
						resultArrayPos++;
					}
				}
			}
			numbers = resultArray;
			
		}
		return numbers;
	}

}
