public class MovieReviewWordLengthProfiler {
    public static void classifyWordLengths(String review) {
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        String trimmedReview = review.trim();
        if (!trimmedReview.isEmpty()) {
            String[] words = trimmedReview.split("\\s+");
            for (String word : words) {
                int length = word.length();
                if (length <= 4) {
                    shortWords++;
                } else if (length <= 8) {
                    mediumWords++;
                } else {
                    longWords++;
                }
            }
        }
        System.out.println("Short: " + shortWords
                + " | Medium: " + mediumWords
                + " | Long: " + longWords);
    }
    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
