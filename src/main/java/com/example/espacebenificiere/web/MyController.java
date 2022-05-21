package com.example.espacebenificiere.web;

import com.example.espacebenificiere.security.entities.AppRole;
import com.example.espacebenificiere.security.entities.AppUser;
import com.example.espacebenificiere.security.entities.Beneficiary;
import com.example.espacebenificiere.security.entities.Schedule;
import com.example.espacebenificiere.security.repositories.AppRoleRepository;
import com.example.espacebenificiere.security.repositories.AppUserRepository;
import com.example.espacebenificiere.security.repositories.BeneficiaryRepository;
import com.example.espacebenificiere.security.repositories.ScheduleRepository;
import com.example.espacebenificiere.security.services.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;


@Controller
@AllArgsConstructor
public class MyController {
    private SecurityService securityService;
    private AppRoleRepository appRoleRepository;
    private AppUserRepository appUserRepository;
    private PasswordEncoder passwordEncoder;
    private ScheduleRepository scheduleRepository;
    private BeneficiaryRepository beneficiaryRepository;


    @GetMapping(path = "/user/signUp")
    public String inscription(Model model){
        model.addAttribute("beneficiary" , new Beneficiary());
        return "signUpPage";
    }


    @GetMapping(path = "/")
    public String home(){
        return "redirect:/welcomePage";
    }




    @GetMapping(path = "welcomePage")
    public String welcome(){
        return "welcomePage";
    }


    @GetMapping(path = "/user/editPage")
    public String editPage(Model model){
        AppUser appUser = getCurrentUser();
        if (appUser == null) throw new RuntimeException("Not exist");
        model.addAttribute("beneficiary", appUser);
        return "editPage";
    }

    public AppUser  getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        return appUserRepository.findAppUserByEmail(currentPrincipalName);
    }


    @GetMapping(path = "/user/saveSingUp")
    public String saveSingUp(@Valid AppUser appUser){
        System.out.println(appUser.toString());
        appUser.setActive(true);
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
        addRoleToUser("USER" , appUser.getEmail());
        return "redirect:/welcomePage";
    }


    public void addRoleToUser(String roleName, String email) {
        AppUser appUser = appUserRepository.findAppUserByEmail(email);
        if (appUser == null) throw new RuntimeException("User with " + email + " does not exist!!");

        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole == null) throw new RuntimeException("Role with " + roleName + " does not exist!!");

        appUser.getAppRoles().add(appRole);//?? why we didn't add save > appUserRepo.save(beneficiary);

        appUserRepository.save(appUser);//> it is not necessary since we add @Transactional
        //> update the field automatically;
    }

    @GetMapping(path = "/user/saveEdit")
    public String saveEdit(@Valid Beneficiary beneficiary){
        appUserRepository.save(beneficiary);
        return "redirect:/welcomePage";
    }


    @GetMapping(path = "/user/choicesUser")
    public String choices(Model model){
        //todo: make a logic to not let the user choose 'Lundi' as a 1st and 2nd .. choice >
        String[] days = {"Lundi" , "Mardi" , "Mercredi" , "Jeudi"};
        model.addAttribute("days", days);
        Schedule schedule = scheduleRepository.findById(getCurrentUser().getUserId()).orElse(null);
        String[] chosenDays = {"" , "" ,"" ,""};
        if (schedule != null){
            chosenDays = new String[]{schedule.getC1(), schedule.getC2(), schedule.getC3(), schedule.getC4()};
        }
        model.addAttribute("chosenDays" , chosenDays);
        return "choicesUser";
    }

    @PostMapping(path = "/user/saveChoices")
    public String saveChoices(Model model ,
                              @RequestParam(name = "c1" , defaultValue = "") String c1,
                              @RequestParam(name = "c2" , defaultValue = "") String c2,
                              @RequestParam(name = "c3" , defaultValue = "") String c3,
                              @RequestParam(name = "c4" , defaultValue = "") String c4) {
        model.addAttribute("c1", c1);
        Long id = getCurrentUser().getUserId();
        scheduleRepository.save(new Schedule(id, c1, c2, c3, c4));
        return "/welcomePage";
    }


    //For ADMIN
    @GetMapping(path = "/admin/choicesUsersAdmin")
    public String choicesUsersAdmin(Model model ){
        List<Beneficiary> beneficiaryList = beneficiaryRepository.findAll();
        List<Schedule>  schedulesList = scheduleRepository.findAll();
        model.addAttribute("scheduleList" , schedulesList);
        model.addAttribute("beneficiaryList" , beneficiaryList);
        return "choicesUsersAdmin";
    }

}
