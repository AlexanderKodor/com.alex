package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Преступление и наказание")
    public String name;
    @Value("Ф.М. Достовский")
    private String author;
    @Value("1866")
    private int yersOfPublication;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYersOfPublication() {
        return yersOfPublication;
    }
}
