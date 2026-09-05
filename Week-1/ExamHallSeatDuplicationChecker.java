public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null) {
            System.out.println("No Duplicate Seats Found");
            return;
        }
        boolean duplicateFound = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyReported = false;
            for (int previous = 0; previous < i; previous++) {
                if (seatNumbers[previous] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) {
                continue;
            }
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }
    public static void main(String[] args) {
        checkDuplicateSeats(new int[] {101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[] {101, 102, 103, 104, 105});
    }
}
