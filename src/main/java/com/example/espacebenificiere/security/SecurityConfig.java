package com.example.espacebenificiere.security;

import com.example.espacebenificiere.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration //dire que c'est une classe de config
//les class de config se sont initialisé au démarage
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DataSource dataSource; //dire a Spri sec la BD qu il va utiliser
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    //comment sp sec va chercher les utili et les roles
    //utilisant de bd , memoire , ....
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
     }


    //Specifier les droits d'accées
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.formLogin(); //> use the default login   ;; .loginPage("/login")> customize the login page

        //UserDetails
        http.authorizeHttpRequests().antMatchers("/").permitAll();
        http.authorizeHttpRequests().antMatchers("/saveSingUp").permitAll();
        http.authorizeHttpRequests().antMatchers("/welcomePage").permitAll();
        http.authorizeHttpRequests().antMatchers("/signUpPage/**").permitAll();
        http.authorizeHttpRequests().antMatchers("/admin/**").hasAuthority("ADMIN"); // on peut utiliser l'annotation dans les methods.
        http.authorizeHttpRequests().antMatchers("/user/**").hasAuthority("USER");
        http.authorizeHttpRequests().antMatchers("/webjars/**").permitAll();//> spr sec refuse also the static elements like load bootstrap ...
        http.authorizeHttpRequests().anyRequest().authenticated(); //toutes les req http nessisite une authentification
        http.exceptionHandling().accessDeniedPage("/403");
    }

}


