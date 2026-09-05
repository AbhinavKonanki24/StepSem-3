public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.isEmpty()) {
            return "Rejected \u2014 invalid file type";
        }
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex <= 0 || dotIndex == filename.length() - 1) {
            return "Rejected \u2014 invalid file type";
        }
        String extension = filename.substring(dotIndex + 1);
        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected \u2014 invalid file type";
    }
    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}
