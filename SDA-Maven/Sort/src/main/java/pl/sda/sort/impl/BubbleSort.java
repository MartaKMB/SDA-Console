package pl.sda.sort.impl;

import pl.sda.sort.Sort;

public class BubbleSort implements Sort {

	@Override
	public int[] sort(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - i; j++) {
				if (j < numbers.length - 1 && numbers[j] > numbers[j + 1]) {
					swapArrayValues(numbers, j, j + 1);
				}
			}
		}
		return numbers;
	}

	private void swapArrayValues(int[] array, int indexA, int indexB) {
		int temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
	}

}
