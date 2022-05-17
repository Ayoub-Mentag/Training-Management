package com.example.espacebenificiere;

import com.example.espacebenificiere.security.entities.AppRole;
import com.example.espacebenificiere.security.repositories.AppRoleRepository;
import com.example.espacebenificiere.security.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EspaceBenificiereApplication {

    public static void main(String[] args) {
        SpringApplication.run(EspaceBenificiereApplication.class, args);
    }

//      @Bean
//    CommandLineRunner saveUsers(AppRoleRepository appRoleRepository){
//        return args -> {
////            securityService.saveNewUser("mohammed" , "1234" , "1234");
////            securityService.saveNewUser("yassine" , "1234" , "1234");
////            securityService.saveNewUser("hassan" , "1234" , "1234");
//
//            appRoleRepository.save(new AppRole(null , "USER", ""));
//            appRoleRepository.save(new AppRole(null , "ADMIN", ""));
//
////            securityService.addRoleToUser("mohammed" , "USER");
////            securityService.addRoleToUser("mohammed" , "ADMIN");
////            securityService.addRoleToUser("yassine" , "USER");
////            securityService.addRoleToUser("hassan" , "USER");
//
//        };
//    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
