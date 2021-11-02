package aop;

import org.springframework.stereotype.Component;

@Component//("libraryBean") - о умолчанию будет uniLibrary
public class UniLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary");
    }

    public void addBook() {
        System.out.println("Мы добавили книгу в UniLibrary");
    }

    public void returnBook() {
        System.out.println("Мы вернули книгу в UniLibrary");
    }

    @Override
    public void getMagazine(Magazine magazine) {
        System.out.printf("Мы берем журнал %s из SchoolLibrary", magazine.getName());
    }

    public void addMagazine() {
        System.out.println("Мы добавили журнал в UniLibrary");
    }

    public void returnMagazine() {
        System.out.println("Мы вернули журнал в UniLibrary");
    }

}
