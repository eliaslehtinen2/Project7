package main;

public class FictionBook extends Book implements Borrowable {
    private int borrowedCopies = 0;

    public FictionBook(String title, String author, int pages, int copies) {
        super(title, author, pages, copies);
    }
    
    public String categorize() {
        return "Fiktiokirja";
    }

    public void borrow() {
        if (copies > 0) {
            copies--;
            borrowedCopies++;
            System.out.println("Kirja " + title + " on nyt lainattu.");
        } else {
            System.out.println("Kirjaa " + title + " ei enään ole lainattavissa!");
        }
    }

    public void returnBook() {
        if (borrowedCopies > 0) {
            copies++;
            borrowedCopies--;
            System.out.println("Kirja " + title + " on palautettu.");
        } else {
            System.out.println("Kirja " + title + " ei ole lainassa.");
        }
    }
    
}
