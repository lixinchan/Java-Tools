package org.example.core.java.generics;

/**
 * @author clx
 * @param <T>
 */
public class Pair<T> {

	private T first;
	private T second;

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}

	public static <T> void swapHelper(Pair<T> p) {
		T t = p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
}
