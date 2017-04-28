package pl.sda.sort;

public interface Sort {

	public enum Type {
		BUBBLE, COUNT, INSERT
	}

	public int[] sort(int[] numbers);
}
