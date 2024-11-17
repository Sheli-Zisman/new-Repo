import java.util.ArrayList;

/**
 * 
 * The SharedData class provides storage for the list of integers, a target
 * integer,
 * 
 * a boolean array to track winning conditions, and
 * 
 * a flag to signal the status of a search.
 * 
 */

public class SharedData

{

	private ArrayList<Integer> arraylist = new ArrayList<>();

	private boolean[] winArray;

	private boolean flag;

	private final int b;

	/**
	 * 
	 * Description of SharedData
	 * 
	 * A constructor that accepts an ArrayList and an integer
	 * 
	 * @param array an ArrayList of integers to store the numbers that will be
	 *              checked
	 * 
	 * @param b     an integer value that sent to check whether there are two
	 *              numbers in the array whose addition is equal to it
	 * 
	 */

	public SharedData(ArrayList<Integer> arrayList, int b) {

		this.arraylist = arrayList;

		this.b = b;

	}

	/**
	 * 
	 * Description of getWinArray
	 * 
	 * 
	 * 
	 * @return a boolean array that store the win/lose status.
	 * 
	 */

	public boolean[] getWinArray()

	{

		return winArray;

	}

	/**
	 * 
	 * Description of setWinArray
	 * 
	 * Sets the boolean array that stores the win/lose status.
	 * 
	 * @param winArray a boolean array that shows the win/lose status.
	 * 
	 */

	public void setWinArray(boolean[] winArray)

	{

		this.winArray = winArray;

	}

	/**
	 * 
	 * Description of getArray
	 * 
	 * @return an ArrayList of integers to be checked.
	 * 
	 */

	public ArrayList<Integer> getArray()

	{

		return arraylist;

	}

	/**
	 * 
	 * Description of getB
	 * 
	 * @return an integer value that represent the target sum.
	 * 
	 * 
	 * 
	 */

	public int getB()

	{

		return b;

	}

	/**
	 * 
	 * Description of getFlag
	 * 
	 * @return A boolean value that represent if a solution has been found.
	 * 
	 */

	public boolean getFlag()

	{

		return flag;

	}

	/**
	 * 
	 * Description of setFlag
	 * 
	 * Sets the status of the solution search flag.
	 * 
	 * @param flag a boolean value to indicate if a solution has been found.
	 * 
	 */

	public void setFlag(boolean flag) {

		this.flag = flag;

	}

}
