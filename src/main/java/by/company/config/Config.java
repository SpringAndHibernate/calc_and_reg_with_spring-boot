package by.company.config;

import by.company.entities.Operation;
import by.company.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public List<User> userList(){
        return new ArrayList();
    }

    @Bean
    public List<Operation> operationList(){
        return new ArrayList();
    }
}
