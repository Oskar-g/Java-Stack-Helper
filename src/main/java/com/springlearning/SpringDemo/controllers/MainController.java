package com.springlearning.SpringDemo.controllers;

import com.springlearning.SpringDemo.models.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    public String init(ModelMap model){
        model.put("msg", "Prueba");
        return "index";
    }

    @PostMapping("getPersona")
    public String subm(ModelMap model, Persona persona){
        model.put("persona", persona);

        return "index :: parcial";
    }
}
