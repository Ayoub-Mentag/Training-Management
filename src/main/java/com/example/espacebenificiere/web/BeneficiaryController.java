package com.example.espacebenificiere.web;

import com.example.espacebenificiere.Entities.Beneficiary;
import com.example.espacebenificiere.Repositories.BeneficiaryRepository;
import com.example.espacebenificiere.security.entities.AppRole;
import com.example.espacebenificiere.security.entities.AppUser;
import com.example.espacebenificiere.security.repositories.AppRoleRepository;
import com.example.espacebenificiere.security.repositories.AppUserRepository;
import com.example.espacebenificiere.security.services.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.UUID;


@Controller
@AllArgsConstructor
public class BeneficiaryController {
    private SecurityService securityService;
    private AppRoleRepository appRoleRepository;
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;
    @GetMapping(path = "inscription")
    public String inscription(Model model){
        model.addAttribute("beneficiary" , new Beneficiary());
        return "inscription";
    }

//    @GetMapping(path = "firstPage")
//    public String firstPage(){
//        return "firstPage";
//    }

    @GetMapping(path = "/")
    public String home(){
        return "redirect:/welcomePage";
    }




    @GetMapping(path = "welcomePage")
    public String welcome(){
        return "welcomePage";
    }


    @GetMapping(path = "/editPage")
    public String editPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        AppUser appUser = appUserRepository.findAppUserByEmail(currentPrincipalName);
        if (appUser == null) throw new RuntimeException("Not exist");
        model.addAttribute("appUser" , appUser);
        return "editPage";
    }

    @GetMapping(path = "/signUpPage")
    public String signUpPage(Model model){
        model.addAttribute("appUser" , new AppUser());
        return "signUpPage";
    }

    @GetMapping(path = "/saveSingUp")
    public String saveSingUp(@Valid AppUser appUser){
        System.out.println(appUser.toString());
//        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setActive(true);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
        addRoleToUser("USER" , appUser.getEmail());
        return "redirect:/welcomePage";
    }


    private void addRoleToUser(String roleName, String email) {
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        if (appUser == null) throw new RuntimeException("User with " + email + " does not exist!!");

        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole == null) throw new RuntimeException("Role with " + roleName + " does not exist!!");

        appUser.getAppRoles().add(appRole);//?? why we didn't add save > appUserRepo.save(appUser);

        appUserRepository.save(appUser);//> it is not necessary since we add @Transactional
        //> update the field automatically;
    }

    @GetMapping(path = "/saveEdit")
    public String saveEdit(@Valid AppUser appUser){
        appUserRepository.save(appUser);
        return "redirect:/welcomePage";
    }


    @GetMapping(path = "/choices")
    public String choices(){
        return "choicesUser";
    }

}
