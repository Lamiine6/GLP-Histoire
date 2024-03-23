package chrono;

public class Chronometer {
	private CyclicCounter minute = new CyclicCounter(0, 59, 0);
	private CyclicCounter second = new CyclicCounter(0, 59, 0);

	public void increment() {
		second.increment();
		if (second.getValue() == 0) {
			minute.increment();
		}

	}

	public void decrement() {
		second.decrement();
		if (second.getValue() == 59) {
			minute.decrement();
		}
	}

	public CyclicCounter getMinute() {
		return minute;
	}

	public CyclicCounter getSecond() {
		return second;
	}

	public String toString() {
		return minute.toString() + " : " + second.toString();
	}

	public static String transform(int value) {
		String result = "";
		if (value < 10) {
			result = "0" + value;
		} else {
			result = String.valueOf(value);
		}
		return result;
	}

	public void init() {
		minute.setValue(0);
		second.setValue(0);
	}

}
