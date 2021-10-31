package aop;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("Мы берем книгу из SchoolLibrary");
    }

    @Override
    public void getMagazine(Magazine magazine) {
        System.out.printf("Мы берем журнал %s из SchoolLibrary", magazine.getName());
    }

}
