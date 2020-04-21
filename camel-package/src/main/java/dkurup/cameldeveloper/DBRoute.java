package dkurup.cameldeveloper;

import dkurup.cameldeveloper.repository.UserRepository;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DBRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//            from("timer:runonce?repeatCount=1")
//                    .to("jpa:dkurup.cameldeveloper.domain.User")
//                    .process(exchange -> {
//                        System.out.println("Do nothing");
//                    })
//                    .to("stream:out");

        from("timer:runonce?repeatCount=1")
                .bean(UserRepository.class,"findAll")
                .process(exchange -> {
                        System.out.println("Do nothing");
                 })
                 .to("stream:out");

    }
}
