package book;

public interface Manageable {
    void addItem(Book book);
    void displayAll();
    void saveToFile();
    void loadFromFile();
}
