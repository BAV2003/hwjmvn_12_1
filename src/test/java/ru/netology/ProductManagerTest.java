package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    @Test
    public void addTest() {
        ProductRepository basket = new ProductRepository();
        ProductManager manager = new ProductManager(basket);

        Book book1 = new Book(1, "book 1", 1000, "Martin");
        Book book2 = new Book(2, "book 2", 1050, "Tolkien");
        Smartphone phone1 = new Smartphone(3, "phone 1", 17990, "Apple");
        Smartphone phone2 = new Smartphone(4, "phone 2", 19990, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] expected = { book1, book2, phone1, phone2 };
        Product[] actual = basket.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTest() {
        ProductRepository basket = new ProductRepository();
        ProductManager manager = new ProductManager(basket);

        Book book1 = new Book(1, "book 1", 1000, "Martin");
        Book book2 = new Book(2, "book 2", 1050, "Tolkien");
        Smartphone phone1 = new Smartphone(3, "phone 1", 17990, "Apple");
        Smartphone phone2 = new Smartphone(4, "phone 2", 19990, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] expected = { book1, book2 };
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);
    }

}
