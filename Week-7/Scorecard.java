public class Scorecard {
    private final boolean[] answers;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.answers = new boolean[Math.max(0, totalQuestions)];
        this.recordedCount = 0;
    }

    public Scorecard() {
        this(10);
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < answers.length) {
            answers[recordedCount++] = isCorrect;
        } else {
            System.out.println("Answer rejected: maximum question limit reached (" + answers.length + ")");
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }

    public int getTotalQuestions() {
        return answers.length;
    }

    public int getRecordedCount() {
        return recordedCount;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("sc.getScore() -> " + sc.getScore());

        // Attempting to record more than the fixed question count
        sc.recordAnswer(true);
        System.out.println("Score after extra record attempt -> " + sc.getScore());
    }
}
