/** RSLL */
public class RotatingSLList<Item> extends SLList<Item> {
    public SLList<Item> rsl;

    public RotatingSLList(){
        rsl = new SLList<Item>();
    }

    /** Rotates list to the right by one item */
    public void rotateRight(){
        Item x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> rsl = new RotatingSLList<Integer>();
        rsl.addLast(10);
        rsl.addLast(11);
        rsl.addLast(12);
        rsl.addLast(13);

        rsl.rotateRight();
        rsl.print();
    }

}