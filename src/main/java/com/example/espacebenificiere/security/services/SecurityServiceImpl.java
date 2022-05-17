package com.example.espacebenificiere.security.services;

import com.example.espacebenificiere.security.entities.AppRole;
import com.example.espacebenificiere.security.entities.AppUser;
import com.example.espacebenificiere.security.repositories.AppRoleRepository;
import com.example.espacebenificiere.security.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Transactional //all the method are transactional
               // > at the end of executing the method he(spring)commits
               // > so the others
@Service //cuz it s a service
@Slf4j //permet de loger >
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

//    @Override
//    //todo : add the other fields
//    public AppUser saveNewUser(String username, String password, String rePassword) {
//        if (!password.equals(rePassword)){
//            throw new RuntimeException("Password not match");//dans la pratique il faut créer customized exception
//        }
//        String encodedPassword = passwordEncoder.encode(password);
//        AppUser appUser = new AppUser();
//        appUser.setUserId(UUID.randomUUID().toString());//generate a random string
//        appUser.setEmail(username);
//        appUser.setPassword(encodedPassword);
//        appUser.setActive(true);
//        AppUser savedAppUser = appUserRepository.save(appUser);
//        return savedAppUser;
//    }
//
//    @Override
//    public AppRole saveNewRole(String roleName, String description) {
//        AppRole appRole = appRoleRepository.findByRoleName(roleName);
//        if (appRole != null) throw new RuntimeException("Role with " + roleName + " already exists!!");
//
//        appRole = new AppRole();
//        appRole.setRoleName(roleName);
//        appRole.setDescription(description);
//        AppRole savedAppRole = appRoleRepository.save(appRole);
//        return savedAppRole;
//    }
//
//    @Override
//    public void addRoleToUser(String email, String roleName) {
//        AppUser appUser = appUserRepository.findAppUserByEmail(email);
//        if (appUser == null) throw new RuntimeException("User with " + email + " does not exist!!");
//
//        AppRole appRole = appRoleRepository.findByRoleName(roleName);
//        if (appRole == null) throw new RuntimeException("Role with " + roleName + " does not exist!!");
//
//        appUser.getAppRoles().add(appRole);//?? why we didn't add save > appUserRepo.save(appUser);

//        appUserRepository.save(appUser);> it is not necessary since we add @Transactional
        //> update the field automatically;
//    }

//    @Override
//    public void removeRoleFromUser(String username, String roleName) {
//        AppUser appUser = appUserRepository.findAppUserByEmail(username);
//        if (appUser == null) throw new RuntimeException("User with " + username + " does not exist!!");
//
//        AppRole appRole = appRoleRepository.findByRoleName(roleName);
//        if (appRole == null) throw new RuntimeException("Role with " + roleName + " does not exist!!");
//
//        appUser.getAppRoles().remove(appRole);//?? why we didn't add save > appUserRepo.save(appUser);
//
//    }

    @Override
    public AppUser loadByUserName(String username) {
        AppUser appUser = appUserRepository.findAppUserByEmail(username);
        if (appUser == null) throw new RuntimeException("User with " + username + " does not exist!!");

        return appUser;
    }
}
