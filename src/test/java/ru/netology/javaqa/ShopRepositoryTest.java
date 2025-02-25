package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 55);
        Product product2 = new Product(2, "Пицца", 555);
        Product product3 = new Product(3, "Телефон", 55_000);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1,product3};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void testNotExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 55);
        Product product2 = new Product(2, "Пицца", 555);
        Product product3 = new Product(3, "Телефон", 55_000);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, ()->repo.remove(222));
    }
}