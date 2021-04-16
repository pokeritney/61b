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
 */
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

public class ArrayDemo {
    public static void main (String[] args) {
        /*Create an array of five integers. */
        int[] someArray = new int[5];
        someArray[0] = 3;
        someArray[1] = 4;
    }
}