import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ExamQuestion {
    protected final String questionText;
    protected final String correctAnswer;
    protected final String studentAnswer;
    protected final double points;

    public ExamQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract String getQuestionType();
    public abstract double grade();
}

class McqQuestion extends ExamQuestion {
    public McqQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "MCQ";
    }

    @Override
    public double grade() {
        if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return points;
        }
        return 0.0;
    }
}

class TfQuestion extends ExamQuestion {
    public TfQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "TF";
    }

    @Override
    public double grade() {
        if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return points;
        }
        return 0.0;
    }
}

class EssayQuestion extends ExamQuestion {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "ESSAY";
    }

    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchedCount = 0;
        String answerLower = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && answerLower.contains(trimmedKw)) {
                matchedCount++;
            }
        }

        if (matchedCount >= 2) {
            return 0.75 * points; // 75% for 2 or more keywords
        } else if (matchedCount == 1) {
            return 0.50 * points; // 50% for 1 keyword
        } else {
            return 0.0;
        }
    }
}

public class ExaminationQuestionGrader {
    public static List<String> parseTokens(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (Character.isWhitespace(c) && !inQuotes) {
                if (current.length() > 0) {
                    tokens.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }

        if (current.length() > 0) {
            tokens.add(current.toString());
        }
        return tokens;
    }

    public static ExamQuestion createQuestion(List<String> tokens) {
        String type = tokens.get(0).toUpperCase();
        String questionText = tokens.get(1);
        String correctAnswer = tokens.get(2);
        String studentAnswer = tokens.get(3);
        double points = Double.parseDouble(tokens.get(4));

        switch (type) {
            case "MCQ":
                return new McqQuestion(questionText, correctAnswer, studentAnswer, points);
            case "TF":
                return new TfQuestion(questionText, correctAnswer, studentAnswer, points);
            case "ESSAY":
                return new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void processQuestions(List<ExamQuestion> questions) {
        double overallScore = 0.0;
        for (ExamQuestion question : questions) {
            double score = question.grade();
            System.out.printf("%s: %.2f%n", question.getQuestionType(), score);
            overallScore += score;
        }
        System.out.printf("Total Score: %.2f%n", overallScore);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<ExamQuestion> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }

            List<String> tokens = parseTokens(line);
            if (tokens.size() >= 5) {
                questions.add(createQuestion(tokens));
            }
        }

        processQuestions(questions);
    }
}
