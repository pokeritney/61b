/** Array based list
 * @author Selene Huang
 */

/*Invariant:
addLast: the next item we want to add, will go into position [size]
getLast: the item we want to return is in position [size - 1]
size: the number of items in the list should be size
 */
public class AList<Item> implements List61B<Item> {
    //define our private variables
    private Item[] items;
    private int size;


    /*Creates an empty list*/
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    @Override
    /* add Item x to first */
    public void addFirst(Item x) {
        insert(x, 0);
    }

    public void resize(int capacity) {
        Item[] a = (Item[])  new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    @Override
    /*Inserts X into the back of the list*/
    public void addLast(Item x) {
        //add a resizing method to deal the case when items is full
        if (size == items.length) {
            resize(size * 2);
        }
        //below two lines will handle
        items[size] = x;
        size += 1;
    }

    @Override
    /*returns the item from the back of the list*/
    public Item getLast() {
        return items[size - 1];
    }

    @Override
    /*returns the item from the beginning of the list*/
    public Item getFirst() {
        return items[0];
    }

    @Override
    /*Gets the ith item in the list*/
    public Item get(int i) {
        return items[i];
    }

    @Override
    /*returns the number of items in the list*/
    public int size() {
        return size;
    }

    @Override
    /*Deletes item from back of the list and returns deleted item*/
    public Item removeLast() {
        Item x = getLast();
        items[size - 1] = null;
        size -= 1;
        return x;
    }

    @Override
    /* insert item x into the given position in SLList
    If position is greater than size, insert at the end
    Here the position refers to actual position, not index
     */
    public void insert(Item x, int position) {
        Item[] newitems = (Item[]) new Object[items.length + 1];
        System.arraycopy(items, 0, newitems, 0, position);
        newitems[position] = x;
        System.arraycopy(items, position, newitems, position + 1, items.length - position);
        size += 1;
        items = newitems;
    }
}
