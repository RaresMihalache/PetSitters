package com.example.demo.controller;


import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.service.OwnerService;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;
    private Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    @Autowired
    private PetService petService;

    @GetMapping("index")
    public String index(Authentication authentication, Model model) {
        Optional<Owner> owner = ownerService.getOwnerByUsername(authentication.getName());
        if(owner.isPresent()){
            model.addAttribute("balance", owner.get().getBalance());
        }
        return "owner/index";

    }

    @GetMapping("viewProfile")
    public String viewProfile(Authentication authentication, Model model){
        System.out.println(authentication.getName());
        Optional<Owner> owner = ownerService.getOwnerByUsername(authentication.getName());
        if(owner.isPresent()){
            model.addAttribute("password", owner.get().getPassword());
            model.addAttribute("balance", owner.get().getBalance());
            model.addAttribute("pets", owner.get().getPets());
        }
        return "owner/viewProfile";
    }

    @GetMapping("editProfile")
    public String editProfile(Authentication authentication, Model model){
        //Pet pet = new Pet();
        Optional<Owner> owner = ownerService.getOwnerByUsername(authentication.getName());
        if(owner.isPresent()) {
            //model.addAttribute("pet", pet);
            model.addAttribute("owner", owner);
            //model.addAttribute("balance", owner.get().getBalance());
            System.out.println(owner.get().getUsername() + " username ");
            System.out.println(owner.toString());
            //System.out.println(pet.toString());
        }
        else {
            System.out.println("username nu a fost gasit");
        }
        return "owner/editProfile";
    }
    /*@PostMapping("editProfile")
    public String editProfilePost(Model model, @ModelAttribute("owner") Owner owner, @ModelAttribute("pet") Pet pet){
        Optional<Owner> foundOwner;
        foundOwner = ownerService.getOwnerByUsername(owner.getUsername());
        if(foundOwner.isPresent()){
            System.out.println("gasit");
        }
        else{
            System.out.println("negasit");
        }
        return "owner/editProfile";
    }*/

    /*@GetMapping("updateProfile")
    public String updatePf(){
        return "owner/updateProfile";
    }*/

    @PostMapping("updateProfile")
    public String updateProfile(Authentication authentication, Model model, @ModelAttribute("owner") Owner owner){
        Optional<Owner> foundOwner;
        Pet pet = new Pet();
        pet.setName(owner.getPets().get(0).getName());
        pet.setType(owner.getPets().get(0).getType());
        pet.setBreed(owner.getPets().get(0).getBreed());
        pet.setAge(owner.getPets().get(0).getAge());
        pet.setDetails(owner.getPets().get(0).getDetails());
        //pet.setOwner(owner);

        System.out.println(pet.toString());

        System.out.println(owner.toString());
        foundOwner = ownerService.getOwnerByUsername(authentication.getName());
        if(foundOwner.isPresent()) {
            ownerService.updateOwner(foundOwner.get().getUsername(), owner.getBalance(), pet);
            System.out.println("ownerul a fost gasit");
            System.out.println(foundOwner.toString());
        }
        else {
            System.out.println("haha hihi");
        }
        model.addAttribute("foundOwner", foundOwner);
        return "owner/updateProfile";
    }

/*    @GetMapping("editProfile")
    public String editProfile(Authentication authentication, Model model){
        Optional<Owner> owner = ownerService.getOwnerByUsername(authentication.getName());
        if(owner.isPresent()){
            model.addAttribute("balance", owner.get().getBalance());
            model.addAttribute("pets", owner.get().getBalance());
        }
        return "owner/editProfile";
    }*/

    /*@PostMapping("editProfile")
    public String editProfile(Authentication authentication, Model model, @ModelAttribute("owner") Optional<Owner> owner){ //@ModelAttribute("owner") Owner owner){
        owner = ownerService.getOwnerByUsername(authentication.getName());
        if(owner.isPresent()){
            model.addAttribute("balance", owner.get().getBalance());
            model.addAttribute("pets", owner.get().getBalance());
        }

        return "owner/editProfiles";
    }*/

    @GetMapping("searchSitter")
    public String searchSitter(Authentication authentication, Model model){
        Optional<Owner> owner = ownerService.getOwnerByUsername(authentication.getName());
        if(owner.isPresent()){
            model.addAttribute("balance", owner.get().getBalance());
        }

        return "owner/searchSitter";
    }

    @GetMapping("makeAppointment")
    public String makeAppointment(Authentication authentication, Model model){
        Optional<Owner> owner = ownerService.getOwnerByUsername(authentication.getName());
        if(owner.isPresent()){
            model.addAttribute("balance", owner.get().getBalance());
        }

        return "owner/makeAppointment";
    }

}
