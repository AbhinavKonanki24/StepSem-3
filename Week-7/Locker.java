public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.code != null && this.code.equals(currentCode)) {
            this.code = newCode;
            System.out.println("success");
            return true;
        } else {
            System.out.println("rejected, code is still unchanged");
            return false;
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println("Locker " + l.getLockerNumber() + " created.");

        System.out.print("l.changeCode(\"1234\", \"5678\") -> ");
        l.changeCode("1234", "5678");

        System.out.print("l.changeCode(\"0000\", \"9999\") -> ");
        l.changeCode("0000", "9999");
    }
}
