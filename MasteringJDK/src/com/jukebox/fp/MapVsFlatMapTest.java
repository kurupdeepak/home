package com.jukebox.fp;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapVsFlatMapTest {
    public static void main(String[] args) {
        List<User> userList = Arrays.asList(new User("Alex", Arrays.asList("Toronto","Mississauga")),
                new User("Tom", Arrays.asList("Etobicoke","Oakville")),
                new User("John", Arrays.asList("Milton","Mississauga")),
                new User("Tony", Arrays.asList("Edmonton","Mississauga")));

        Map<String,List<String>> listMap = userList.stream().collect(Collectors.toMap(User::getName,User::getAddress));
        //[User] has places in [locations]
      /*  userList.stream()
                .map(user -> {user.name = user.name + " lives in ";
                              user.name +=  user.address.stream().flatMap().collect(Collectors.joining());
                              return user;
                })
                .forEach((user) -> System.out.println(user.name));*/
//                .reduce("",(a,a1) -> a + "," + a1));
        IntStream intStream = IntStream.range(1,10);
        intStream.average()
        .ifPresent(System.out::println);
        Optional<Optional<String>> str = Optional.of("string")
                .map(s -> Optional.of("STRING"));

        Optional<String> str1 = Optional.of("string")
                .flatMap(s -> Optional.of("STRING"));
        System.out.println();
    }

}


class User{
    String name;
    List<String> address;

    public User(String name, List<String> address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}