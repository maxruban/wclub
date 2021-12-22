package com;

import com.config.ConfigApp;
import com.domain.*;
import com.domain.enums.*;
import com.service.*;
import com.service.impl.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestProject {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        UserService userService = context.getBean(UserServiceImpl.class);
        CRUDService<Role> roleService = context.getBean(RoleServiceImpl.class);
        ProducerServiceImpl producerService = context.getBean(ProducerServiceImpl.class);  //????
        ProductServiceImpl productService = context.getBean(ProductServiceImpl.class); //????
        ProductPreferenceServiceImpl productPreferenceService = context.getBean(ProductPreferenceServiceImpl.class);
        OrderServiceImpl orderService = context.getBean(OrderServiceImpl.class);


//        Role adminRole = Role.builder()
//                .role(Roles.ADMIN)
//                .build();
//        roleService.add(adminRole);
//
//        Role userRole = Role.builder()
//                .role(Roles.USER)
//                .build();
//        roleService.add(userRole);
//
//        Role superAdminRole = Role.builder()
//                .role(Roles.SUPER_ADMIN)
//                .build();
//        roleService.add(superAdminRole);
//

//
//        Contact contact = Contact.builder()
//                .number("0505555555")
//                .type(TypeOfContact.CELL_PHONE)
//                .build();
//
//        Contact contact1 = Contact.builder()
//                .number("0503333333")
//                .type(TypeOfContact.VIBER)
//                .build();
//
//        Address address = Address.builder()
//                .apartment("2")
//                .street("Lenina")
//                .city(City.DNIPRO)
//                .specialInformation("red door")
//                .build();
//
//        Role role = roleService.getById(6);
//
//        User user1 = User.builder()
//                .addresses(Set.of(address))
//                .contacts(Set.of(contact, contact1))
//                .dob(LocalDate.of(1980, 10, 10))
//                .firstName("Alex")
//                .lastName("Smith")
//                .middleName("Petrovich")
//                .email("alexsmith@email.com")
//                .login("alexsmith@email.com")
//                .password("password123")
//                .expertLevel(ExpertLevel.BEGINNER)
//                .roles(Set.of(role))
//                .discount(Discount.FIVE)
//                .build();
//
//        userService.add(user1);

//        Producer producer1 = Producer.builder()
//                .country(Country.ITALY)
//                .name("Masseto")
//                .description("The best-performing Italian wine on the market in terms of value and sale volume. " +
//                        "Masseto grew in price by 24% between 2016 and 2017, " +
//                        "and it’s expected to continue to increase in value over the next few years")
//                .build();
//        producerService.add(producer1);

//
//        Product cabernet = Product.builder()
//                .name("Masseto Cabernet")
//                .producer(producerService.getById(19))
//                .vintage(Year.of(2018))
//                .alcoholByVolume("14.5")
//                .description("I generally recommend this wine to collectors who already adore New-World wines " +
//                        "especially Napa Valley Cabernet) and who want to ease their way into Italian wine for the first time.")
//                .body(Body.MEDIUM_BODIED)
//                .acidity(Acidity.LOW_ACIDIC)
//                .color(Color.RED)
//                .alcohol(Alcohol.MEDIUM_ALCOHOL)
//                .tannin(Tannin.MEDIUM_HIGH)
//                .sweetness(Sweetness.SEMI_SWEET)
//                .type(ProductType.WINE)
//                .imageUrl("https://www.img12345.png")
//                .price1(new BigDecimal(299.99))
//                .price2(new BigDecimal(279.99))
//                .available(true)
//                .build();
//
//        productService.add(cabernet);
//

//        ProductPreference productPreference = ProductPreference.builder()
//                .acidity(List.of(Acidity.HIGH_ACIDIC, Acidity.MEDIUM_ACIDIC))
//                .alcohol(List.of(Alcohol.MEDIUM_ALCOHOL))
//                .body(List.of(Body.FULL_BODIED, Body.MEDIUM_BODIED))
//                .color(List.of(Color.RED, Color.WHITE))
//                .sweetness(List.of(Sweetness.DRY, Sweetness.SEMI_DRY))
//                .tannin(List.of(Tannin.MEDIUM,Tannin.MEDIUM_LOW))
//                .types(List.of(ProductType.WINE, ProductType.BLEND_WINE))
//                .user(userService.getById(8))
//                .created(LocalDate.of(2021,11,22))
//                .build();
//
//        productPreferenceService.add(productPreference);


        User user = userService.getById(8);
        Set<Address> addresses = user.getAddresses();

        List<Address> list = new ArrayList<>(addresses);
        Product prod1 = productService.getById(22);
        Product prod2 = productService.getById(24);

        Order order = Order.builder()
                .user(user)
                .deliveryAddress(list.get(0))
                .deliveryDate(LocalDate.of(2021, 11, 24))
                .products(Set.of(prod1, prod2))
                .total(new BigDecimal(200.99))
                .build();
        orderService.add(order);


    }


}
