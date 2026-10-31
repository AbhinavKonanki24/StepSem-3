public class NameTag {
    private final String firstName;
    private final String lastName;
    private final String nickname;

    public NameTag(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            this.firstName = "";
            this.lastName = "";
            this.nickname = "";
            return;
        }
        String[] parts = fullName.trim().split(" ");
        this.firstName = parts[0];
        if (parts.length > 1 && !parts[1].isEmpty()) {
            this.lastName = parts[1];
            this.nickname = this.firstName + " " + this.lastName.charAt(0) + ".";
        } else {
            this.lastName = "";
            this.nickname = this.firstName;
        }
    }

    public String getNickname() {
        return nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> " + tag.getNickname());

        NameTag tag2 = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname().equals(tag2.getNickname()): " + tag.getNickname().equals(tag2.getNickname()));
        System.out.println("tag == tag2 (separate objects): " + (tag == tag2));
    }
}
