//package com.config.security;
//
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan(basePackages = "com")
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@Import(EncoderConfig.class)
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@AllArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    PasswordEncoder passwordEncoder;
//
//    UserDetailsService service;
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
////                .withUser("John").password("$2a$10$o6KG2YjPh0y..J0OOHtIyOxh.M8F9XreyjG27e9idiMoOUaAOq/4K").roles("USER")//123
////                .and()
////                .withUser("Jack").password("$2a$10$2NNoYNKFa6M0AG/hThzWFeiMqlCb40H6oFP3FOsu207y8y8YFX2Xm").roles("USER", "ADMIN");//123456
////
////    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(service)
//                .passwordEncoder(passwordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
//        http.csrf().disable()// disable security service "cross-site request forgery"
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/login*", "/club/user")                  // specify url
//                .permitAll()
////                .antMatchers(HttpMethod.POST, "/club/user")                  // specify url
////                .permitAll()                                              // permitted to all users of any role (we can use .anonymous())
//                //We do it manually, later we will just add annotations:
////                .antMatchers("/club/security/admin").hasRole("ADMIN")        // url and role user has to have to point this url
////                .antMatchers("/club/security/user").hasRole("USER")          // url and role user has to have to point this url
//                .anyRequest()                                                     // all other request
//                .authenticated()                                                  // must be authenticated
//                .and()
//                .formLogin()                                                      // return login page
//                .defaultSuccessUrl("/club/security/main", true) // it opens this page after successful login
//                .usernameParameter("user_name")
//                .passwordParameter("password")
//                .and()
//                .logout();
//    }
//}
