public class PangramUsingBitwise {

    public static boolean hasAllDigits(String s) {

        int mask = 0;

        for (char c : s.toCharArray()) {

            if (c >= '0' && c <= '9') {

                int pos = c - '0';
                mask |= (1 << pos);
            }
        }

        return mask == ((1 << 10) - 1);
    }

    public static void main(String[] args) {

        String s = "98765432100123456789";

        System.out.println(hasAllDigits(s));
    }
}