//Larger Demo

/**
public class Practice {
    /**
     * print out integers from 0 to 9
     * @param x
     * @param y
     * @return int
    public static ifPass (int score) {
        boolean pass = score >= 75;
        if (pass) {
            output("You pass");
        }
        else {
            //The following line executes if and only if score < 75.
            output("You fail");
        }
        return None;
    }
    System.out.println(ifPass(80));
}

public class DrawTriangle {
public static void drawTriangle(int N) {
int row = 0;
int col = 0;

while (row < N) {
while (col <= row) {
System.out.print("*");
col += 1;
}
col = 0;
row += 1;
System.out.println();
}
}
public static void main(String[] args) {
drawTriangle(10);
}
}

public class Practice {
    public static void main (String[] args) {
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};

        for (String s: a) {
            for (int j = 0; j < 3; j += 1) {
                System.out.println(s);
                if (s.contains("horse")) {
                    break;
                }
            }
        }
    }
}
*/

public class Practice {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using recursion*/
    public int size() {
        //base case
        if (rest == null) {
            return 1;
        }
        return this.rest.size() + 1;
    }

    /** Return the size of the list using iteration*/
    public int iterativeSize() {
        int size = 0;
        IntList p = this;
        while (p != null) {
            p = C.rest;
            size +=1;
        }
        return size;
    }

    /** Return the ith item in the list*/
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntList incrList(IntList L, int x) {
        //base case
        if (incrL == null) {
            return null;
        }
        //increment L by recursion
        IntList incrL = new IntList(L.first + x, null);
        incrL.rest = incrList(L.rest, x);

        return incrL;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        //base case
        if (L == null) {
            return null;
        }
        L.first += x;
        dincrList(L.rest, x);
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        //Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        System.out.println(L.get(1));
        System.out.println(incrList(L, 3));
        System.out.println(dincrList(L, 3));


        //public static void main(String[] args) {
        //IntList L = new IntList(15, null);
        //L = new IntList(10, L);
        //L = new IntList(5, L);

        //System.out.println(L.size());
    }
}

