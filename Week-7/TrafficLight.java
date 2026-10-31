public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public TrafficLight() {
        this("TL-1");
    }

    public String next() {
        if ("RED".equalsIgnoreCase(color)) {
            color = "GREEN";
        } else if ("GREEN".equalsIgnoreCase(color)) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
        return color;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("TrafficLight ID: " + t.getId());
        System.out.println("t.getColor() -> " + t.getColor());
        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
    }
}
