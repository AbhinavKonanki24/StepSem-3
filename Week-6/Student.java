class Student {
    private final String name;
    private final double attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new Student("Ravi", 92.5);
        new Student("Anitha", 88.0);
        System.out.println("2 Student objects created");
        Student.printCollegeInfo();
    }
}