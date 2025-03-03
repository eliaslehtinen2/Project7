package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("1) Lisää kirja");
            System.out.println("2) Listaa kirjat");
            System.out.println("3) Lainaa fiktiokirja");
            System.out.println("4) Palauta fiktiokirja");
            System.out.println("0) Lopeta ohjelma");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Minkä kirjan haluat lisätä kirjastoon? 1) Fiktiokirja, 2) Tietokirja");
                    int bookType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Anna kirjan nimi:");
                    String title = scanner.nextLine();
                    System.out.println("Anna kirjailijan nimi:");
                    String author = scanner.nextLine();
                    System.out.println("Anna sivumäärä:");
                    int pages = scanner.nextInt();
                    System.out.println("Anna kirjojen määrä:");
                    int copies = scanner.nextInt();
                    scanner.nextLine();

                    if (bookType == 1) {
                        library.addBook(new FictionBook(title, author, pages, copies));
                    } else if (bookType == 2) {
                        library.addBook(new NonFictionBook(title, author, pages, copies));
                    } else {
                        System.out.println("Virheellinen kirjatyyppi.");
                        break;
                    }

                    System.out.println("Kirja lisätty kirjastoon!");
                    break;

                case 2:
                    library.listBooks();
                    break;

                case 3:
                    System.out.println("Anna lainattavan kirjan nimi:");
                    String borrowedTitle = scanner.nextLine();
                    Book borrowedBook = library.findBook(borrowedTitle);

                    if (borrowedBook instanceof FictionBook) {
                        ((FictionBook) borrowedBook).borrow();
                    } else {
                        System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
                    }
                    break;

                case 4:
                    System.out.println("Anna palautettavan kirjan nimi:");
                    String returnTitle = scanner.nextLine();
                    Book returnBook = library.findBook(returnTitle);

                    if (returnBook instanceof FictionBook) {
                        ((FictionBook) returnBook).returnBook();
                    } else {
                        System.out.println("Kirjaa ei löytynyt tai sitä ei voi palauttaa.");
                    }
                    break;

                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Virheellinen valinta, yritä uudelleen.");
                    break;
            }
        }
    }
}
