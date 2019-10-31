package Sorting;

public class Circle implements Comparable<Circle>{

	int radius;

	public Circle(int i) {
		this.radius = i;
	}

	@Override
	public int compareTo(Circle o) {
		return this.radius - o.radius;
	}

}
