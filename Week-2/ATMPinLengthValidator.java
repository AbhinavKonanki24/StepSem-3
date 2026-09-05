public class ATMPinLengthValidator {
    public static void checkPinLength(String pin) {
        boolean valid = pin != null && pin.length() == 4;
        if (valid) {
            for (int i = 0; i < pin.length(); i++) {
                if (!Character.isDigit(pin.charAt(i))) {
                    valid = false;
                    break;
                }
            }
        }
        if (!valid) {
            System.out.println("Invalid PIN \u2014 must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
    public static void main(String[] args) {
        checkPinLength("482");
        checkPinLength("4820");
    }
}
