class Book {
    int id;
    String title;
    Book next;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.next = null;
    }
}

public class LibraryCatalog {
    Book head;

    // Append book at end
    void appendBook(int id, String title) {
        Book newBook = new Book(id, title);
        if (head == null) {
            head = newBook;
        } else {
            Book temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newBook;
        }
    }

    // Display catalog
    void displayCatalog() {
        System.out.println("Library Catalog:");
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.id + " - " + temp.title);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        LibraryCatalog catalog = new LibraryCatalog();
        byte[] input = new byte[10000];
        int len = System.in.read(input);
        String[] lines = (new String(input, 0, len)).trim().split("\n");

        if (lines.length < 1) {
            return;
        }

        int n = Integer.parseInt(lines[0].trim());
        int index = 1;

        for (int i = 0; i < n && index + 1 < lines.length; i++) {
            int id = Integer.parseInt(lines[index].trim());
            String title = lines[index + 1].trim();
            catalog.appendBook(id, title);
            index += 2;
        }

        catalog.displayCatalog();
    }
}
