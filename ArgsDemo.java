public class ArgsDemo {
    public static void main (String[] args) {
        //print the sum of integers in args
        int sum = 0;
        int i = 0;
        while (i < args.length) {
            sum += Integer.parseInt(args[i]);
            i += 1;
        }
        System.out.println(sum);
    }
}