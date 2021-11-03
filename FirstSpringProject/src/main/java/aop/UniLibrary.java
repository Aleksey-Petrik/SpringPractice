package aop;

import org.springframework.stereotype.Component;

@Component//("libraryBean") - о умолчанию будет uniLibrary
public class UniLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary");
        System.out.println("----------------------------");
    }

    public void addBook() {
        System.out.println("Мы добавили книгу в UniLibrary");
        System.out.println("----------------------------");
    }

    public void returnBook() {
        System.out.println("Мы вернули книгу в UniLibrary");
        System.out.println("----------------------------");
    }

    @Override
    public void getMagazine(Magazine magazine) {
        System.out.printf("Мы берем журнал %s из SchoolLibrary", magazine.getName());
        System.out.println("----------------------------");
    }

    public void addMagazine(String person, Magazine magazine) {
        System.out.printf("Мы добавили журнал %s в UniLibrary", magazine.getName());
        System.out.println("----------------------------");
    }

    public void returnMagazine() {
        System.out.println("Мы вернули журнал в UniLibrary");
        System.out.println("----------------------------");
    }

}
