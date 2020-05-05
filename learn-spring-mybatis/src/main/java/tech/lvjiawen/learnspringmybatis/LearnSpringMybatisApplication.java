package tech.lvjiawen.learnspringmybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.lvjiawen.learnspringmybatis.jdbc.model.Employee;
import tech.lvjiawen.learnspringmybatis.jdbc.repository.EmployeeMyBatisRepository;

@SpringBootApplication
public class LearnSpringMybatisApplication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeMyBatisRepository employeeMyBatisRepository;

    @Override
    public void run(String...args) {
        logger.info("Inserting -> {}", employeeMyBatisRepository.insert(new Employee(10011L, "Ramesh", "Fadatare", "ramesh@gmail.com")));
    }


    public static void main(String[] args) {
        SpringApplication.run(LearnSpringMybatisApplication.class, args);
    }

}