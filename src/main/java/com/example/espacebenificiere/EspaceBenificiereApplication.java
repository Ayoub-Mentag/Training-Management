package com.example.espacebenificiere;

import com.example.espacebenificiere.security.entities.Admin;
import com.example.espacebenificiere.security.entities.AppChoice;
import com.example.espacebenificiere.security.entities.AppGroup;
import com.example.espacebenificiere.security.entities.Beneficiary;
import com.example.espacebenificiere.security.repositories.AdminRepository;
import com.example.espacebenificiere.security.repositories.AppChoiceRepository;
import com.example.espacebenificiere.security.repositories.AppGroupRepository;
import com.example.espacebenificiere.security.repositories.AppUserRepository;
import com.example.espacebenificiere.web.MyController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EspaceBenificiereApplication {

    public static void main(String[] args) {
        SpringApplication.run(EspaceBenificiereApplication.class, args);
    }

  //  @Bean
    public CommandLineRunner commandLineRunner(AppUserRepository appUserRepository , AdminRepository adminRepository , MyController myController , PasswordEncoder passwordEncoder) {
//        return args -> {
//            Beneficiary beneficiary = new Beneficiary();
//            beneficiary.setEmail("oussama@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("Oussama");
//            beneficiary.setLName("Aderdour");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("imad@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("imad");
//            beneficiary.setLName("imad");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("mehdi@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("mehdi");
//            beneficiary.setLName("mehdi");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("youssef@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("youssef");
//            beneficiary.setLName("youssef");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("anass@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("anass");
//            beneficiary.setLName("anass");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("badr@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("badr");
//            beneficiary.setLName("badr");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("zaim@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("zaim");
//            beneficiary.setLName("zaim");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("mohssin@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("mohssin");
//            beneficiary.setLName("mohssin");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("kamal@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("kamal");
//            beneficiary.setLName("kamal");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("mohammed@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("mohammed");
//            beneficiary.setLName("mohammed");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("rachid@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("rachid");
//            beneficiary.setLName("rachid");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("said@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("said");
//            beneficiary.setLName("said");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("ismail@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("ismail");
//            beneficiary.setLName("ismail");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("karim@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("karim");
//            beneficiary.setLName("karim");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("monir@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("monir");
//            beneficiary.setLName("monir");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("khalid@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("khalid");
//            beneficiary.setLName("khalid");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("driss@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("driss");
//            beneficiary.setLName("driss");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("abderazak@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("abderazak");
//            beneficiary.setLName("abderazak");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("abderahim@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("abderahim");
//            beneficiary.setLName("abderahim");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("abderahman@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("abderahman");
//            beneficiary.setLName("abderahman");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("anouar@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("anouar");
//            beneficiary.setLName("anouar");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("khadija@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("khadija");
//            beneficiary.setLName("khadija");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("fatima@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("fatima");
//            beneficiary.setLName("fatima");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("aicha@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("aicha");
//            beneficiary.setLName("aicha");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("karima@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("karima");
//            beneficiary.setLName("karima");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("yassmine@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("yassmine");
//            beneficiary.setLName("yassmine");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("yamna@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("yamna");
//            beneficiary.setLName("yamna");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("rayan@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("rayan");
//            beneficiary.setLName("rayan");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("bilal@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("bilal");
//            beneficiary.setLName("bilal");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("hamza@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("hamza");
//            beneficiary.setLName("hamza");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("yassine@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("yassine");
//            beneficiary.setLName("yassine");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//
//            beneficiary = new Beneficiary();
//            beneficiary.setEmail("othman@gmail.com");
//            beneficiary.setPassword(passwordEncoder.encode("123456"));
//            beneficiary.setAcR("SALE");
//            beneficiary.setActive(true);
//            beneficiary.setCyE("Cycle");
//            beneficiary.setEta("EST");
//            beneficiary.setSom("123");
//            beneficiary.setDirP("Dir");
//            beneficiary.setFName("othman");
//            beneficiary.setLName("othman");
//            beneficiary.setFon("A");
//            beneficiary.setTel("0612345678");
//            appUserRepository.save(beneficiary);
//myController.addRoleToUser("USER" , beneficiary.getEmail());
//
//        };

        return args -> {
            Admin admin = new Admin();
            admin.setEmail("admin");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setActive(true);
            adminRepository.save(admin);
            myController.addRoleToUser("ADMIN" , "admin");
        };
    }


    @Bean
    public PasswordEncoder passwordEncoder () {
                return new BCryptPasswordEncoder();
            }

  //  @Bean
    public CommandLineRunner commandLineRunner(AppGroupRepository groupRepository){
        return args -> {
            groupRepository.save(new AppGroup(null , "Lundi Matin" , -1));
            groupRepository.save(new AppGroup(null , "Lundi Apr??s Midi" , -1));
            groupRepository.save(new AppGroup(null , "Mardi Matin" , -1));
            groupRepository.save(new AppGroup(null , "Mardi Apr??s Midi" , -1));
            groupRepository.save(new AppGroup(null , "Mercredi Matin" , -1));
            groupRepository.save(new AppGroup(null , "Mercredi Apr??s Midi" , -1));
            groupRepository.save(new AppGroup(null , "Jeudi Matin" , -1));
            groupRepository.save(new AppGroup(null , "Jeudi Apr??s Midi" , -1));
            groupRepository.save(new AppGroup(null , "Vendredi Matin" , -1));

        };
    }

 //   @Bean
    public CommandLineRunner printDays(AppGroupRepository appGroupRepository){
        return args -> {
            List<AppGroup> appGroups = appGroupRepository.findAll();
            System.out.println(appGroups);
        };
    }
        }

