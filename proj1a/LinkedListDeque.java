/*
a generic linked list deque with circular sentinels.
@author: Selene Huang
 */

public class LinkedListDeque<T> {
    /*IntNode with one item T, one previous DoubleNode and one next DoubleNode*/
    private class DoubleNode {
        public T item;
        public DoubleNode prev;
        public DoubleNode next;

        public DoubleNode(DoubleNode p, T i, DoubleNode n) {
            prev = p;
            item = i;
            next = n;
        }

        public T get(int index) {
            if (index <= 0) {
                return item;
            } else if (this == sentinel) {
                return null; //returns null if index out of bound
            }
            return next.get(index - 1);
        }
    }

    /*
    the first item is at sentinel.next.item
    and the last item is at sentinel.prev.item
    * */
    private DoubleNode sentinel;
    private int size;

    /* Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new DoubleNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /* Creates a deep copy of other */
    public LinkedListDeque(LinkedListDeque<T> other) {
        //assume other is a generic deque same as this
        //initialize a new sentinel first
        sentinel = new DoubleNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        //loop through other and append its element into the deep copy
        for (int i = 0; i < other.size(); i += 1) {
            addLast((T)other.get(i)); //needs to make sure this and other are of the same type
        }
    }

    /*Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        DoubleNode first = new DoubleNode(sentinel, item, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }

    /*Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        DoubleNode last = new DoubleNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    /*Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        return size == 0;
    }

    /*Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /*Prints the items in the deque from first to last, separated by a space.
    Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        DoubleNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /*Removes and returns the item at the front of the deque
    If no such item exists, returns null.
    */
    public T removeFirst() {
        if (isEmpty()) return null; //if there is no first, return null
        //otherwise, return the first item and destroy its reference within deque
        DoubleNode remove = sentinel.next;
        sentinel.next = remove.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return remove.item;
    }

    /*Removes and returns the item at the back of the deque.
    If no such item exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) return null;
        DoubleNode last = sentinel.prev;
        sentinel.prev = last.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return last.item;
    }

    /*Gets the item at the given index,
    where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        //do not need to check if isEmpty, since sentinel.item = null
        DoubleNode p = sentinel.next;
        while (p != sentinel && index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item; //will return null is index out of bound or no such item
    }

    /*Same as get, but uses recursion.*/
    public T getRecursive(int index) {
        //Use DoubleNode's helper function get
        DoubleNode p = sentinel.next;
        return p.get(index);
    }


}