//package com.controller;
//
//import com.domain.Order;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("security")
//public class SecurityController {
//
//    @GetMapping("/user")
//    @Secured("ROLE_USER")
//    public void actionUser() {
//
//        System.out.println("Hello user!");
//    }
//
//    @GetMapping("/admin")
//    @Secured({"ROLE_ADMIN", "ROLE_SUPER_ADMIN"})
//    public void actionAdmin() {
//        System.out.println("Hello admin!");
//
//    }
//
//    @GetMapping("/super-admin")
//    @Secured("ROLE_SUPER_ADMIN")
//    public void actionSuperAdmin() {
//        System.out.println("Hello admin!");
//
//    }
//
//    @GetMapping("/main")
//    public void actionLoggedIn() {
//        System.out.println("Hello logged in admin!"  + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//    }
//}
