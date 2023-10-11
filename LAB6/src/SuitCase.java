//package KI306.Khmilovskiy.Lab6;
import java.util.ArrayList;

/**
 * A generic class representing a suitcase that can hold items of type T.
 * @param <T> The type of items that the suitcase can hold.
 */
class SuitCase<T extends Item> {
    private ArrayList<T> items;

    /**
     * Constructs a new SuitCase object.
     */
    public SuitCase() {
        items = new ArrayList<>();
    }

    /**
     * Finds the item with the minimum size in the suitcase.
     * @return The item with the minimum size, or null if the suitcase is empty.
     */
    public T findMin() {
        if (!items.isEmpty()) {
            T min = items.get(0);
            for (int i = 1; i < items.size(); i++) {
                if (items.get(i).compareTo(min) < 0)
                    min = items.get(i);
            }
            return min;
        }
        return null;
    }

    /**
     * Adds an item to the suitcase.
     * @param item The item to be added.
     */
    public void addItem(T item) {
        items.add(item);
        System.out.print("Item added: ");
        item.print();
    }

    /**
     * Removes an item from the suitcase at the specified index.
     * @param i The index of the item to be removed.
     */
    public void removeItem(int i) {
        if (i >= 0 && i < items.size()) {
            items.remove(i);
            System.out.println("Item removed at index " + i);
        } else {
            System.out.println("Invalid index. Cannot remove item.");
        }
    }

    /**
     * Prints the contents of the suitcase.
     */
    public void printContents() {
        if (!items.isEmpty()) {
            for (T item : items) {
                item.print();
            }
        } else {
            System.out.println("SuitCase is empty. No items available.");
        }
    }
}

/**
 * A class representing clothing items.
 */
class Clothing implements Item {
    private String clothingType;
    private String clothingBrand;
    private double clothingCost;
    private int clothingSize;

    /**
     * Constructs a new Clothing object.
     *
     * @param cType   The type of clothing.
     * @param cBrand  The brand of clothing.
     * @param cCost   The cost of clothing.
     * @param cSize   The size of clothing.
     */
    public Clothing(String cType, String cBrand, double cCost, int cSize) {
        clothingType = cType;
        clothingBrand = cBrand;
        clothingCost = cCost;
        clothingSize = cSize;
    }

    // SET + GET [TYPE]
    public String getClothingType() {
        return clothingType;
    }

    public void setClothingType(String type) {
        clothingType = type;
    }

    // SET + GET [BRAND]
    public String getClothingBrand() {
        return clothingBrand;
    }

    public void setClothingBrand(String brand) {
        clothingBrand = brand;
    }

    // SET + GET [COST]
    public double getClothingCost() {
        return clothingCost;
    }

    public void setClothingCost(double cost) {
        clothingCost = cost;
    }

    // SET [SIZE]
    public void setClothingSize(int size) {
        clothingSize = size;
    }

    // Implementing methods from Item interface:
    public int getSize() {
        return clothingSize;
    }

    public int compareTo(Item item) {
        Integer s = clothingSize;
        return s.compareTo(item.getSize());
    }

    public void print() {
        System.out.println("[Clothing]");
        System.out.println("  Type: " + clothingType);
        System.out.println("  Brand: " + clothingBrand);
        System.out.println("  Cost: " + clothingCost + " $");
        System.out.println("  Size: " + clothingSize);
        System.out.println();
    }
}

/**
 * A class representing books.
 */
class Book implements Item {
    private String bookName;
    private String bookGenre;
    private int bookPublicationYear;
    private int bookSize;

    /**
     * Constructs a new Book object.
     *
     * @param bName              The name of the book.
     * @param bGenre             The genre of the book.
     * @param bPublicationYear   The publication year of the book.
     * @param bSize              The size of the book.
     */
    public Book(String bName, String bGenre, int bPublicationYear, int bSize) {
        bookName = bName;
        bookGenre = bGenre;
        bookPublicationYear = bPublicationYear;
        bookSize = bSize;
    }

    // SET + GET [NAME]
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String name) {
        bookName = name;
    }

    // SET + GET [GENRE]
    public String getBookGenre() {
        return bookGenre;
    }
    public void setBookGenre(String genre) {
        bookGenre = genre;
    }

    // SET + GET [YEAR]
    public int getBookPublicationYear() {
        return bookPublicationYear;
    }
    public void setBookPublicationYear(int year) {
        bookPublicationYear = year;
    }

    // SET [SIZE]
    public void SetBookSize(int n) {
        bookSize = n;
    }

    // Implementing methods from Item interface:
    public int getSize() {
        return bookSize;
    }
    public int compareTo(Item item) {
        Integer s = bookSize;
        return s.compareTo(item.getSize());
    }
    public void print() {
        System.out.println("[Book]");
        System.out.println("  Name: " + bookName);
        System.out.println("  Genre: " + bookGenre);
        System.out.println("  Publication Year: " + bookPublicationYear);
        System.out.println("  Size: " + bookSize);
        System.out.println();
    }
}
