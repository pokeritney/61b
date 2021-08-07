/** Array based Deque
 * @author Selene Huang
 */

/*Invariant:
addLast: the next item we want to add, will go into position [nextLast]
getLast: the item we want to return is in position [nextLast - 1]
size: the number of items in the list should be size
 */

public class ArrayDeque<T> {
    //define our private variables
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int initSize = 4;

    /*Creates an empty list
    * The starting size of your array should be 8
    */
    public ArrayDeque() {
        items = (T[]) new Object[initSize];
        int mid = items.length / 2;
        nextFirst = mid - 1;
        nextLast = mid;
        size = 0;
    }

    /* Creates a deep copy of other. */
    public ArrayDeque(ArrayDeque<T> other) {
        items = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, items, 0, other.items.length);
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.size;
    }

    /* resize the items */
    public void resize(int capacity) {
        T[] newItems = (T[])  new Object[capacity];
        //  0  1  2  3  4  5  6  7
        //       [x][x][x][x]       items (copy array)
        // [ ][ ][s][ ][ ][ ][ ][ ] newItems
        //    [x][x][x]             if initSize is an odd number
        // [ ][ ][ ][ ][ ][ ]
        int startPos = newItems.length / 2 - size / 2;
        int oldIndex = nextFirst + 1;
        int newIndex = startPos;
        int count = 0;
        while (count < size) {
            newItems[newIndex] = items[oldIndex % items.length];
            oldIndex ++;
            newIndex++;
            count++;
        }
        items = newItems;
        nextFirst = startPos - 1;
        nextLast = newIndex;
    }

    /* resize down the arrayDeque */
    private void resizeDown() {
        //if size is less than half of initSize,
        resize(size * 2 < initSize ? initSize : size * 2);
    }

    /* add a T item to first */
    public void addFirst(T item) {
        //expand size when arrayDeque is full
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
    }

    /*Inserts X into the back of the list*/
    public void addLast(T x) {
        //add a resizing method to deal the case when items is full
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = x;
        size += 1;
        nextLast = (nextLast + 1) % items.length;
    }

    /* Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space.
    Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        int count = 0;
        int first = nextFirst + 1;
        while (count < size) {
            System.out.print(items[first % items.length]);
            first ++;
            count ++;
        }
        System.out.println();
    }

    /* Removes and returns the item at the front of the deque.
    If no such item exists, returns null. */
    public T removeFirst() {
        if (isEmpty()) return null;
        //if usage ratio less than 1/4, size down
        if ((double) size / items.length < 0.25 && items.length > initSize) {
            resizeDown();
        }
        nextFirst = (nextFirst + 1) % items.length;
        T removeItem = items[nextFirst];
        items[nextFirst] = null; // set to null so no memory waste
        size -= 1;
        return removeItem;
    }

    /* Removes and returns the item at the end of the deque.
    If no such item exists, returns null. */
    public T removeLast() {
        if (isEmpty()) return null;
        //if usage ratio less than 1/4, size down
        if ((double) size / items.length < 0.25 && items.length > initSize) {
            resizeDown();
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        T removeItem = items[nextLast];
        items[nextLast] = null; // set to null so no memory waste
        size -= 1;
        return removeItem;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        //if no such index, returns null
        if (index < 0 || index >= size) {
            return null;
        }

        int pos = nextFirst + 1;
        while (index > 0) {
            pos ++;
            index --;
        }
        return items[pos % items.length]; //handles when index is 0
    }
}