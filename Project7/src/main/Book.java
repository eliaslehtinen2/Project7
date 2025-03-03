package main;

public abstract class Book {

    protected String title;
    protected String author;
    protected int pages;
    protected int copies;

    public Book(String title, String author, int pages, int copies) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.copies = copies;
    }

    public abstract String categorize();

    public void displayInfo() {
        System.out.println("Nimi: " + title + ", Kirjailija: " + author + ", Sivut: " + pages + ", Määrä: " + copies);
        System.out.println("Kirjan kategoria: " + categorize());
    }

    public String getTitle() {
        return title;
    }

    public int getCopies() {
        return copies;
    }

    public void addCopies() {
        copies++;
    }

    public void removeCopies() {
        if (copies > 0) {
            copies--;
        }
    }  
}