/* Selection sort algorithm to destructively sort an array
Author: Selene Huang
 */

public class Sort {
    /* Sort strings destructively */
    public static void sort(String[] x) {
        sort(x, 0);
    }

    /* private helper function to sort starting from index start */
    private static void sort(String[] x, int start) {
        //base case, needs to be x.length in case x is empty
        if (start == x.length) return;
        //find the smallest item
        int smallest = findSmallest(x, start);
        //move it to the front
        swap(x, start, smallest);
        //selection sort the rest (using recursion)
        sort(x, start + 1);
    }

    /* find the smallest item in x starting from index start */
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i += 1) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /*swap x[a] with x[b] */
    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}