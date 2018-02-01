package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ResumeController {

    @Autowired
    ResumeRepository resumeRepository;
    @RequestMapping("/")
    public String listResume(Model model){
        model.addAttribute("resumes" ,resumeRepository.findAll());
        return "index";
    }
    @RequestMapping("/addresume")
    public String resumeForm(Model model){
        model.addAttribute("resume" new Resume());
        return "addresume";
    }
    @PostMapping("/processresume")
    public String processResume(@Valid Resume resume, BindingResult result){
        if(result.hasErrors()){
            return "addresume";
        }
        resumeRepository.save(resume);
        return "redirect:/";
    }

}
