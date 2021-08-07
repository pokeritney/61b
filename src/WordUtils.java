public class WordUtils {
    /* Return the word with the longest length in list */
    public static String longest(List61B<String> list) {
        int maxDex = 0;
        for (int i = 0; i < list.size(); i += 1) {
            String longest = list.get(maxDex);
            String current = list.get(i);
            if (current.length() > longest.length()) {
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static void main (String[] args) {
        List61B<String> someList = new SLList<String>();
        someList.addLast("elk");
        someList.addLast("are");
        someList.addLast("watching");
        System.out.println(longest(someList));
    }
}