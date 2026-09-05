public class BankTransactionReferenceGeneratorValidator {

    public static String normalizeReference(String raw) {
        String trimmedReference = raw.trim();

        if (trimmedReference.length() < 3) {
            return trimmedReference.toUpperCase();
        }

        String bankCode = trimmedReference.substring(0, 3).toUpperCase();
        return bankCode + trimmedReference.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(reference, 0, 3).append("] DATE: ");
        formatted.append(reference, 3, 5).append("/");
        formatted.append(reference, 5, 7).append("/");
        formatted.append(reference, 7, 9).append(" | SEQ: ");
        formatted.append(reference.substring(9));
        return formatted.toString();
    }

    public static void main(String[] args) {
        String normalizedReference = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(normalizedReference));

        normalizedReference = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(normalizedReference));
    }
}
