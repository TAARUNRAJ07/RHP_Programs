public class PangramBitwiseSolution {

    public boolean checkIfPangram(String sentence) {

        if (sentence == null || sentence.isEmpty()) {
            return false;
        }

        int mask = 0;

        for (char character : sentence.toCharArray()) {
            mask |= 1 << (character - 'a');
        }

        return mask == (1 << 26) - 1;
    }

    public static void main(String[] args) {

        PangramBitwiseSolution solution = new PangramBitwiseSolution();

        String sentence1 = "thequickbrownfoxjumpsoverthelazydog";
        String sentence2 = "hello";

        System.out.println(solution.checkIfPangram(sentence1)); // true
        System.out.println(solution.checkIfPangram(sentence2)); // false
    }
}