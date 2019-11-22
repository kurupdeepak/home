package com.kurup.cainerscrapper.demo;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    /*@TestConfiguration

    public static class DataRepositoryConfiguration{

        public @Bean MongoClient mongoClient() {
            return new MongoClient("");
        }
    }*/


    @Test
    public void createPersonTest(){
        personRepository.deleteAll();
        Stream.of(new Person("John"),new Person("Rob"),new Person("Tom"),new Person("Benji"))
                .forEach((p) -> personRepository.save(p) );
        System.out.println("Create = " + personRepository.findAll().stream().count());
        assertEquals(4L,personRepository.findAll().stream().count());
    }



    @Test
//    @Ignore
    public void findAllPersonTest(){
        List<Person> list  =personRepository.findAll();
        list.stream().forEach(System.out::println);
        System.out.println("Find " + list.size());
        assertEquals(4, list.size());
    }
}
