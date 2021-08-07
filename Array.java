public class LengthComparator {
    public interface NullSafeStringComparator {
        /*returns a negative number if s1 is less than s2, 0 if equal and positive
        otherwise
         */
        public int compare(String s1, String s2) {
            int s1Length = s1.length();
            int s2Length = s2.length();
            if ((s1 == null) && (s2 == null)) {
                return 0;
            } else if (s1 == null) {
                return -1;
            } else if (s2 == null) {
                return 1;
            }
            return s1Length - s2Length;
        }
    }

    public static String max(String[] a, NullSafeStringComparator sc) {
        String maxStr = a[0];
        for (int i = 0; i < a.length; i += 1) {
            if (sc.compare(maxStr, a[i]) < 0) {
                maxStr = a[i];
            }
        }
        return maxStr;
    }

    public static String[][] step(String[][] arr) {
        /*all string references in stepped are null by default
        so the edges are correct on initialization
         */
        String[][] stepped = new String[arr.length][arr[0].length];

        for (int i = 1; i < arr.length - 1; i += 1) {
            for (int j = 1; j < arr[0].length - 1; j += 1) {
                String[] temp = new String[9]; //current neightbors and itself
                int count = 0;
                for (int k = -1; k <= 1; k += 1) {
                    for (int m = -1; m <= 1; m += 1) {
                        temp[count] = arr[i + k][j + m];
                        count += 1;
                    }
                }
                stepped[i][j] = max(temp, new LengthComparator());
            }
        }

        return stepped;
    }
}