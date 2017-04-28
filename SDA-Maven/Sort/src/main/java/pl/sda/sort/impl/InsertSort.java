package pl.sda.sort.impl;

import pl.sda.sort.Sort;

public class InsertSort implements Sort {

	public int[] sort(int[] numbers) {

		int i, j, value;

		for (i = 1; i < numbers.length; ++i) {
			value = numbers[i];
			for (j = i - 1; j >= 0 && numbers[j] > value; --j)
				numbers[j + 1] = numbers[j];
			numbers[j + 1] = value;
		}
		return numbers;
	}
}
