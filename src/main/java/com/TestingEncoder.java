package com;

import com.service.OrderService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestingEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("12345"));
//        Person::compareByAge

    }
}
