package dao;

import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookInMemoryDAO implements BookDAO{
    private static List<Book> bookDB = new ArrayList<>();

    static {
        Book b1 = new Book(1, "战争与和平", 34.5f, "朱茂臣", "南方出版社");
        Book b2 = new Book(2, "弟子规", 24.5f, "微帮刚", "北方出版社");
        Book b3 = new Book(3, "Java 编程思想", 44.5f, "罗毅", "西方出版社");
        Book b4 = new Book(4, "Effective Java", 37.5f, "我", "东方出版社");
        Book b5 = new Book(5, "jQuery 从入门到放弃", 111.5f, "他", "南方出版社");

        bookDB.add(b1);
        bookDB.add(b2);
        bookDB.add(b3);
        bookDB.add(b4);
        bookDB.add(b5);
    }
    @Override
    public List<Book> listAll() {

        return bookDB;
    }

    @Override
    public Book getBookById(int id) {
        for (Book book : bookDB) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getBooksByName(String name) {
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : bookDB) {
            String realName = book.getName().toLowerCase();
            if (realName.contains(name.toLowerCase())) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public boolean update(Book book) {
        for (Book bookNew : bookDB){
            if(bookNew.getId() == book.getId()){
                bookNew.setName(book.getName());
                bookNew.setAuthor(book.getAuthor());
                bookNew.setPrice(book.getPrice());
                bookNew.setPress(book.getPress());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (Book book : bookDB) {
            if(book.getId()==id){
                return bookDB.remove(book);
            }
        }
        return false;
    }

    @Override
    public Book add(Book book) {
        if(bookDB.add(book)){
            return book;
        }
        return null;
    }
}
