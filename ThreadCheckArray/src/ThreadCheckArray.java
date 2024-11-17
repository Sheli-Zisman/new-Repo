import java.util.ArrayList;

/**
 * Class for the threads that works on the array
 */
public class ThreadCheckArray implements Runnable {
	private boolean flag;
	private boolean[] winArray;
	SharedData sd;
	ArrayList<Integer> array = new ArrayList<Integer>();
	int b;

	/**
	 * The function receives a SharedData Instance and ensures a thread safe access
	 * 
	 * @param sd SharedData instance for synchronization
	 */
	public ThreadCheckArray(SharedData sd) {
		this.sd = sd;
		synchronized (sd) {
			array = sd.getArray();
			b = sd.getB();
		}
		winArray = new boolean[array.size()];
	}

	/**
	 * A recursive method that synchronizes access to shared data and updates flag
	 * to track progress
	 * 
	 * @param n the current size of the subset
	 * @param b the target value
	 */
	void rec(int n, int b) {
		synchronized (sd) {
			if (sd.getFlag())
				return;
		}
		if (n == 1) {
			if (b == 0 || b == array.get(n - 1)) {
				flag = true;
				synchronized (sd) {
					sd.setFlag(true);
				}
			}
			if (b == array.get(n - 1))
				winArray[n - 1] = true;
			return;
		}

		rec(n - 1, b - array.get(n - 1));
		if (flag)
			winArray[n - 1] = true;
		synchronized (sd) {
			if (sd.getFlag())
				return;
		}
		rec(n - 1, b);
	}

	/**
	 * The method for running the threads. checks conditions on the array and calls
	 * 'rec' method as needed
	 */
	public void run() {
		if (array.size() != 1)
			if (Thread.currentThread().getName().equals("thread1"))
				rec(array.size() - 1, b - array.get(array.size() - 1));
			else
				rec(array.size() - 1, b);
		if (array.size() == 1)
			if (b == array.get(0) && !flag) {
				winArray[0] = true;
				flag = true;
				synchronized (sd) {
					sd.setFlag(true);
				}
			}
		if (flag) {
			if (Thread.currentThread().getName().equals("thread1"))
				winArray[array.size() - 1] = true;
			synchronized (sd) {
				sd.setWinArray(winArray);
			}
		}
	}
}
