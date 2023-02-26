package org.example.store;

import lombok.val;
import org.example.pojo.Book;

import java.sql.SQLException;

import static org.example.jdbc.Postgres.ds;

public class BookStoreService {

    public void persist(Book book){
        try {
          val conn =   ds.getConnection();
          var stmt =   conn.prepareStatement("INSERT INTO publisher(code, publisher_name)VALUES (?, ?)");
          stmt.setString(1, book.getPublisher().getCode());
          stmt.setString(2, book.getPublisher().getName());
          stmt.execute();
          stmt.close();

          stmt = conn.prepareStatement("INSERT INTO book(isbn, book_name, publisher_code)VALUES (?, ?, ?)");
          stmt.setString(1, book.getIsbn());
          stmt.setString(2, book.getName());
          stmt.setString(3, book.getPublisher().getCode());
          stmt.execute();
          stmt.close();

          stmt = conn.prepareStatement("INSERT INTO chapter(book_isbn, chapter_num, title)VALUES (?, ?, ?)");
          stmt.setString(1, book.getIsbn());
          stmt.setInt(2, book.getChapters().get(0).getChapterNumber());
          stmt.setString(3, book.getChapters().get(0).getTitle());
          stmt.execute();
          stmt.close();
          conn.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
