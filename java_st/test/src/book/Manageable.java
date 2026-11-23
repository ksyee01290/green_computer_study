package book;

public interface Manageable {
    void addItem(Book book);
    void displayAll();
    void saveToDB();
    void loadFromDB();
}
