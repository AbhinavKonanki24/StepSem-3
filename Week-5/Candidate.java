import java.util.Arrays;
public class Candidate implements Comparable<Candidate> {
    private final String name;
    private final double cgpa;
    private final int codingScore;
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }
    static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) || (cgpa >= 6.5 && codingScore >= 60);
    }
    private double compositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }
    @Override
    public int compareTo(Candidate other) {
        int scoreComparison = Double.compare(other.compositeScore(), compositeScore());
        if (scoreComparison != 0) {
            return scoreComparison;
        }
        return name.compareTo(other.name);
    }
    static String shortlistAndRank(Candidate[] candidates) {
        int eligibleCount = 0;
        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa, candidate.codingScore)) {
                eligibleCount++;
            }
        }
        Candidate[] shortlisted = new Candidate[eligibleCount];
        int index = 0;
        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[index++] = candidate;
            }
        }
        Arrays.sort(shortlisted);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ")
                    .append(shortlisted[i].name).append(" (")
                    .append(shortlisted[i].compositeScore()).append(")");
        }
        return result.length() == 0 ? "No Eligible Candidates" : result.toString();
    }
    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}