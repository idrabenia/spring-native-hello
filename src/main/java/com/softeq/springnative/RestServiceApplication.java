package com.softeq.springnative;

import org.hibernate.dialect.PostgreSQL95Dialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.TypeHint;

@SpringBootApplication
@TypeHint(types = PostgreSQL95Dialect.class, typeNames = "org.hibernate.dialect.PostgreSQLDialect")
public class RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }

}
