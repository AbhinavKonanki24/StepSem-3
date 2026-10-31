import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected final String title;
    protected static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract LocalDate calculateDueDate();
}

class BookItem extends LibraryItem {
    public BookItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(14); // 14 days
    }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(7); // 7 days
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return CURRENT_DATE.plusDays(3); // 3 days
    }
}

public class LibraryItemDueDateCalculator {
    public static LibraryItem createItem(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK":
                return new BookItem(title);
            case "DVD":
                return new DvdItem(title);
            case "MAGAZINE":
                return new MagazineItem(title);
            default:
                throw new IllegalArgumentException("Unknown library item type: " + type);
        }
    }

    public static void processItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.printf("%s: %s%n", item.getTitle(), item.calculateDueDate());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }

            int firstSpace = line.indexOf(' ');
            if (firstSpace == -1) {
                continue;
            }
            String type = line.substring(0, firstSpace).trim();
            String title = line.substring(firstSpace + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2) {
                title = title.substring(1, title.length() - 1);
            }

            items.add(createItem(type, title));
        }

        processItems(items);
    }
}
