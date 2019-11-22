package com.kurup.cainerscrapper;

import com.kurup.cainerscrapper.demo.Person;
import com.kurup.cainerscrapper.demo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class CainerScrapperApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CainerScrapperApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        createPersonTest();
//        findAllPersonTest();
    }

    @Autowired
    PersonRepository personRepository;

    /*@TestConfiguration

    public static class DataRepositoryConfiguration{

        public @Bean MongoClient mongoClient() {
            return new MongoClient("");
        }
    }*/


    public void createPersonTest(){
        Stream.of(new Person("John"),new Person("Rob"),new Person("Tom"),new Person("Benji"))
                .forEach((p) -> personRepository.save(p) );
//        assertEquals(4,is(personRepository.findAll().stream().count()));
    }



    public void findAllPersonTest(){
        List<Person> list  =personRepository.findAll();
        list.stream().forEach(System.out::println);
//        assertEquals(4, is(list.size()));
    }
}
