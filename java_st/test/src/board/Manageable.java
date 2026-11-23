package board;

public interface Manageable {
    void addItem(Board board);
    void display();
    void updataDB();
    void deletDB();
    void deletAllDB();
    void saveToDB();
    void loadFromDB();
}
