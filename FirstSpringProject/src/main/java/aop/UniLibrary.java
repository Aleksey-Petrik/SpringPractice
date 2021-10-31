package aop;

import org.springframework.stereotype.Component;

@Component//("libraryBean") - о умолчанию будет uniLibrary
public class UniLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary");
    }

    @Override
    public void getMagazine(Magazine magazine) {
        System.out.printf("Мы берем журнал %s из SchoolLibrary", magazine.getName());
    }

    public void returnBook() {
        System.out.println("Мы вернули книгу в UniLibrary");
    }

}
