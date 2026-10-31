public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxStudents) {
        this.presentStudents = new String[Math.max(0, maxStudents)];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (name == null || name.trim().isEmpty()) {
            return;
        }
        if (isPresent(name)) {
            return; // Avoid counting duplicate attendance
        }
        if (count < presentStudents.length) {
            presentStudents[count++] = name;
        } else {
            System.out.println("Attendance sheet is full");
        }
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return count;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
