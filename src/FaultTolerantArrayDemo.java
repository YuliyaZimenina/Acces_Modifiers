public class FaultTolerantArrayDemo {
    public static void main(String[] args) {
        FaultTolerantArray ftArray = new FaultTolerantArray(5, -1);
        int x;

        // Display failures without reporting
        System.out.println("Handing errors without");
        for (int i = 0; i < (ftArray.length * 2); i++)
            ftArray.putValue(i, i * 10); // An array is accessed through its access methods

        for (int i = 0; i < (ftArray.length * 2); i++) {
            x = ftArray.getValue(i);
            if (x != -1) System.out.print(x + " ");
        }
        System.out.println("");

        //Failure handing
        System.out.println("\nHanding errors with reports");
        for (int i = 0; i < (ftArray.length * 2); i++)
            if (!ftArray.putValue(i, i*10))
                System.out.println("Index " + i + " is out of bounds of the array");

        for (int i = 0; i < (ftArray.length * 2); i++) {
            x = ftArray.getValue(i);
            if (x != -1) System.out.print(x + " ");
            else System.out.println("Index " + i + " is out of bounds of the array");
        }
    }
}
