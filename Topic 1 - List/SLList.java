public class SLList<Item> implements List61B<Item>{
    private class IntNode {
        public Item item;
        public IntNode next;

        public IntNode(Item i, IntNode n) {
            item = i;
            next = n;
        }
    }

    //the first item is at sentinel.next
    private IntNode sentinel;
    private int size;

    //single linked list null constructor
    public SLList() {
        sentinel = new IntNode(null, null); //we do not care about the number
        size = 0;
    }
    //with one item constructor
    public SLList(Item x) {
        sentinel = new IntNode(null, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    @Override
    //add item x to first of the SLList
    public void addFirst(Item x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    @Override
    /* get */
    public Item get(int i) {
        IntNode p = sentinel.next;
        while (i > 0 && p.next != null) {
            p = p.next;
            i--;
        }
        return p.item;
    }

    @Override
    //get the first item of SLList
    public Item getFirst() {
        return sentinel.next.item;
    }

    @Override
    /* get the last item of SLList */
    public Item getLast() {
        IntNode p = sentinel;
        while (p != null) {
            p = p.next;
        }
        return p.item;
    }

    @Override
    //add last item to SLList
    public void addLast(Item x) {
        //create a pointer and iterative till the end
        size += 1;
        IntNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    //@Override
    //delete the first item in SLList
    public void deleteFirst() {
        //the first item or the second item can be null
        if (size == 0) {
            System.out.println("SLList does not have a first item to delete!");
            return;
        }
        //create a pointer to the second item
        IntNode p = sentinel.next.next;
        sentinel.next = p;
        size -= 1;
    }

    @Override
    /* delete the last item of SLList */
    public Item removeLast() {
        IntNode p = sentinel;
        while (p.next.next != null) {
            p = p.next;
        }
        Item last = p.next.item;
        p.next = null;
        return last;
    }

    @Override
    //return the size of SLList
    public int size() {
        return size;
    }

    @Override
    /* insert item x into the given position in SLList
    If position is greater than size, insert at the end
     */
    public void insert(Item x, int position) {
        if (sentinel.next == null || position == 0) {
            addFirst(x);
            return;
        }

        IntNode p = sentinel.next;
        while (position > 1 && p.next != null) {
            position--;
            p = p.next;
        }
        IntNode newNode = new IntNode(x, p.next);
        p.next = newNode;
    }

    @Override
    public void print() {
        for (IntNode p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    /* reverse the elements iteratively*/
    public void reverse() {
        //if list is empty, do nothing
        if (sentinel.next == null) return;

        //otherwise, reverse the list starting from zero
        IntNode p = sentinel.next;
        sentinel.next.next = sentinel;

        while (p != null) {
            IntNode pNext = p.next;
            pNext.next = p;
            p = pNext;
        }
    }

    /* reverse the elements recursively*/
    public void reverseRecursive() {
        sentinel.next = reverseHelper(sentinel.next);
    }
    public IntNode reverseHelper(IntNode lst) {
        if (lst == null || lst.next == null) {
            return lst;
        } else {
            IntNode endofReversed = lst.next;
            IntNode reversed = reverseHelper(lst.next);
            endofReversed.next = lst;
            lst.next = null;
            return reversed;
        }
    }


    /**
    public static void main(String[] args) {

        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
        //int x = L.getFirst();
        L.deleteFirst();
        //int y = L.getFirst();

        SLList L = new SLList(new int[] {1, 2, 3});
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
    */
}