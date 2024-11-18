/*
This class implements a fault-tolerant array that prevents
runtime errors from occurring.
 */

public class FaultTolerantArray {
    private int[] userArray; // Array reference
    private int errorValue; // The value returned if the get() method fails
    public int length; // Public member of class

    /*
    The constructor creates an array with specified size and value
    returned if the get() method fails
     */
    public FaultTolerantArray(int size, int errValue) {
        userArray = new int[size];
        errorValue = errValue;
        length = size;
    }

    // A method that returns a value at the given index
    public int getValue(int index) {
        if (indexOK(index)) return userArray[index];
        return errorValue;
    }

    //A method that places a value into an array at a given index
    // If failure occurs, false is returned
    public boolean putValue(int index, int val) {
        if (indexOK(index)) {
            userArray[index] = val;
            return true;
        }
        return false;
    }

    //A method that returns true if the index is within the bounds of the array
    private boolean indexOK(int index) {
        if (index >= 0 & index < length) return true;
        return false;
    }
}