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

public class IntList {
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
            p = p.rest;
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
        if (L == null) {
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
        //Dont care about the return value
        dincrList(L.rest, x);
        return L;
    }

    //square the IntList non-destructively using recursion
    public static IntList square(IntList L) {
        if (L == null) {
            return L;
        } else{
            IntList rest = square(L.rest);
            IntList M = new IntList(L.first * L.first, rest);
            return M;
        }
    }

    //square the IntList destructively using recursion
    public static IntList squareDestructive(IntList L) {
        if (L == null) {
            return L;
        } else {
            L.first *= L.first;
            squareDestructive(L.rest);
        }
        return L;
    }

    //if 2 numbers in a row are the same add them together and make one larger node
    public void addAdjacent() {
        //corner case: when IntList is empty
        if (this == null) {
            return;
        }
        //use a second pointer to loop through first pointer
        IntList p = this;
        while (p.rest != null) {
            if (p.first == p.rest.first) {
                p.first = p.first * 2; //double the first element
                p.rest = p.rest.rest; //remove the repeated element
            } else {
                p = p.rest;
            }
        }

    }

    //every time you add a value you “square” the IntList.
    //1 - 2 to 1 - 1 - 2 - 4
    public void addSquare(int x) {
        //corner case: IntList empty
        if (this == null) {
            return;
        }
        //use two pointers to loop through IntList
        IntList p = this;
        while (p.rest != null) {
            //use a temporary pointer to save the rest
            IntList s = p.rest;
            //square the first item
            p.rest = new IntList(p.first * p.first, s);
            p = s;
        }
        //append x to the end
        IntList a = this;
        while (a.rest != null) {
            a = a.rest;
        }
        a.rest = new IntList(a.first * a.first, null);
        a.rest.rest = new IntList(x, null);
    }

    public static void main(String[] args) {
        /**
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
        System.out.println(L.get(1));
        */

        IntList L = new IntList(2, null);
        L = new IntList(1, L);

        System.out.println(L.size());
        L.addSquare(5);
        System.out.println(L.size());
        System.out.println(L.get(0));
        System.out.println(L.get(1));
        System.out.println(L.get(2));
        System.out.println(L.get(3));
        System.out.println(L.get(4));
    }
}

