package com.example.dao;

import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: ZongYoucheng
 * DateTime: 2021-12-09 12:19
 */
class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    void addBook() {
        bookDao.addBook(new Book(null,"宗有成真棒","宗有成",new BigDecimal(399),130913,0,null));
    }

    @Test
    void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    void updateBook() {
        bookDao.updateBook(new Book(21,"大家棒才是真的棒","宗有成",new BigDecimal(399),130913,0,null));
    }

    @Test
    void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }
}