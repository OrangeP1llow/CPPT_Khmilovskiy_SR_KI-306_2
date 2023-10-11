//package KI306.Khmilovskiy.Lab6;

/**
 * The main class for testing the SuitCase implementation.
 */
public class SuitCaseApp {
    /**
     * The main entry point for the application.
     * @param args Command line arguments.
     */
        public static void main(String[] args) {
            SuitCase<? super Item> suitcase = new SuitCase<>();

            System.out.println();
            suitcase.addItem(new Clothing("Shirt","Burberry", 599, 35));
            suitcase.addItem(new Clothing("Pants", "Nike", 199, 32));

            suitcase.addItem(new Book("\'The Case-Book of Sherlock Holmes\'", "Detective", 2021, 11));
            suitcase.addItem(new Book("\'The Great Gatsby\'", "Fiction", 1925, 10));
            suitcase.addItem(new Book("\'To Kill a Mockingbird\'", "Fiction", 1960, 8));

            suitcase.removeItem(4);

            System.out.print("\nContents of SuitCase: \n");
            suitcase.printContents();

            Item minItem = suitcase.findMin();
            System.out.print("\nThe smallest item in the SuitCase is: ");
            minItem.print();
        }
    }