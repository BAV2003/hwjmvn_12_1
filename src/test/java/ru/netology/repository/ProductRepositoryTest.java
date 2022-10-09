package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.Smartphone;

public class ProductRepositoryTest {

    @Test
    public void findAndSaveTest() {
        ProductRepository basket = new ProductRepository();

        Book book1 = new Book(1, "book 1", 1000, "Martin");
        Book book2 = new Book(2, "book 2", 1050, "Tolkien");
        Smartphone phone1 = new Smartphone(3, "phone 1", 17990, "Apple");
        Smartphone phone2 = new Smartphone(4, "phone 2", 19990, "Samsung");

        basket.save(book1);
        basket.save(book2);
        basket.save(phone1);
        basket.save(phone2);

        Product[] expected = { book1, book2, phone1, phone2 };
        Product[] actual = basket.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeTest() {
        ProductRepository basket = new ProductRepository();

        Book book1 = new Book(1, "book 1", 1000, "Martin");
        Book book2 = new Book(2, "book 2", 1050, "Tolkien");
        Smartphone phone1 = new Smartphone(3, "phone 1", 17990, "Apple");
        Smartphone phone2 = new Smartphone(4, "phone 2", 19990, "Samsung");

        basket.save(book1);
        basket.save(book2);
        basket.save(phone1);
        basket.save(phone2);
        basket.removeById(3);

        Product[] expected = { book1, book2, phone2 };
        Product[] actual = basket.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
