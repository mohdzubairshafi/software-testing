import java.util.EmptyStackException;

class Stack {
	private int[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	public Stack() {
		elements = new int[DEFAULT_CAPACITY];
		size = 0;
	}

	public void push(int value) {
		if (size == elements.length) {
			throw new StackOverflowError("Stack is full");
		}
		elements[size++] = value;
	}

	public int pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return elements[--size];
	}

	public int getSize() {
		return size;
	}

	public static void main(String[] arg) {

	}

}
