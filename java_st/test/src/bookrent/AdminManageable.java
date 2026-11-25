package bookrent;

public interface AdminManageable {
    void bookcreate(Book book);
    void bookdelete(Book book);
    void bookselect(Book book);
    void bookupdate(Book book);
    void peoplemanagement();
    void rentreturn();
    void dbclose();
    void booktotal(Book book);
}
