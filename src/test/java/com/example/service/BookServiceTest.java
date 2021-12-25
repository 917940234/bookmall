package com.example.service;

import com.example.dao.BookDao;
import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: ZongYoucheng
 * DateTime: 2021-12-09 13:15
 */
class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    void addBook() {
        bookService.addBook(new Book(null,"宗大哥的一天","宗有成",new BigDecimal(699),4531452,0,null));
    }

    @Test
    void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    void updateBook() {
        bookService.updateBook(new Book(22,"宗大哥的两天","宗有成",new BigDecimal(699),4531452,0,null));
    }

    @Test
    void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}