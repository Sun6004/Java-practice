package chapter26;

public class Box<T> { // <T> type이 나중에 결정된다는 의미
	private T value;
	
	public Box(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
