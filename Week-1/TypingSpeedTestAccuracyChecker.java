public class TypingSpeedTestAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid typing input");
            return;
        }
        int matchedCharacters = 0;
        int firstMismatch = -1;
        int comparedLength = Math.min(original.length(), typed.length());
        for (int i = 0; i < comparedLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }
        if (firstMismatch == -1 && original.length() != typed.length()) {
            firstMismatch = comparedLength;
        }
        double accuracy = original.length() == 0
                ? 100.0
                : (matchedCharacters * 100.0) / original.length();
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters, original.length(), accuracy);
        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            char originalCharacter = firstMismatch < original.length()
                    ? original.charAt(firstMismatch) : '-';
            char typedCharacter = firstMismatch < typed.length()
                    ? typed.charAt(firstMismatch) : '-';
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n",
                    firstMismatch + 1, originalCharacter, typedCharacter);
        }
    }
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
