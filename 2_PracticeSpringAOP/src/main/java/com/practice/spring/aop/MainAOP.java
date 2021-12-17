package com.practice.spring.aop;

import com.practice.spring.aop.configuration.Config;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.apache.logging.log4j.Logger;

/**
 *
 */
public class MainAOP {
    public static void main(String[] args) {
        Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

        log.info("HELLO");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Book book = context.getBean("book", Book.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook(book);
        uniLibrary.returnBook();
        uniLibrary.getMagazine();

        uniLibrary.addBook("Vermont", 1812);

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();

        context.close();
    }
}
