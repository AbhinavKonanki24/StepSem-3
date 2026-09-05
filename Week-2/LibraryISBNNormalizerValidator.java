public class LibraryISBNNormalizerValidator {
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmedCode = raw.trim();
        if (trimmedCode.length() < 3) {
            return trimmedCode.toUpperCase();
        }
        String publisherCode = trimmedCode.substring(0, 3).toUpperCase();
        return publisherCode + trimmedCode.substring(3);
    }
    public static String validateAndFormat(String code) {
        if (code == null) {
            return "Invalid: code must be exactly 13 characters";
        }
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: code body must contain only digits";
            }
        }
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(code, 0, 3).append("] YEAR: ");
        formatted.append(code, 3, 7).append(" | CATALOG: ");
        formatted.append(code.substring(7));
        return formatted.toString();
    }
    public static void main(String[] args) {
        String normalizedCode = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(normalizedCode));
        normalizedCode = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(normalizedCode));
    }
}
