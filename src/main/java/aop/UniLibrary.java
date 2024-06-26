package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {

    public void getBook(){
        System.out.println("Мы берем книгу из UniLibrary: ");
        System.out.println("-----------------------------------");
    }

    public String returnBook(){
        int a = 10/0;
        System.out.println("Мы возвращаем книгу из UniLibrary.");
        System.out.println("-----------------------------------");
        return "Война и мир";
    }
    public void addBook(String person_name, Book book){
        System.out.println("Мы добавляем книгу из UniLibrary: ");
        System.out.println("-----------------------------------");
    }

    public void getMagazine(){
        System.out.println("Мы берем журнал из UniLibrary.");
        System.out.println("-----------------------------------");
    }
    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал из UniLibrary.");
        System.out.println("-----------------------------------");
    }
    public void addMagazine(){
        System.out.println("Мы добавляем журнал из UniLibrary: ");
        System.out.println("-----------------------------------");
    }
}
