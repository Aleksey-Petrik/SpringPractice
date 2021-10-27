package spring_introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig2 {

    @Bean
    @Scope("prototype")
    public Pet bearBean() {//имя является id бина
        return new Bear();
    }

    @Bean
    @Scope("singleton")
    public PersonHunter personHunterBean() {
        return new PersonHunter(bearBean());
    }

}
