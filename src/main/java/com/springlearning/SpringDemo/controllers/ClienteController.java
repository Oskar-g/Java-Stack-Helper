package com.springlearning.SpringDemo.controllers;

import com.springlearning.SpringDemo.models.entity.Cliente;
import com.springlearning.SpringDemo.models.services.IClienteSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("clientes")
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    @Qualifier("clienteSrv")
    private IClienteSrv clienteSrv;

    @RequestMapping("listar")
    public String listart(ModelMap model) {
        model.put("titulo", "Listado de clientes");
        model.put("clientes", clienteSrv.findAll());
        return "listar";
    }

    @RequestMapping("form")
    public String crear(ModelMap model) {

        Cliente cliente = new Cliente();
        model.put("titulo", "Formulario de cliente");
        model.put("cliente", cliente);
        return "form";
    }

    @RequestMapping("form/{id}")
    public String editar(ModelMap model, @PathVariable(value = "id") Long id) {
        Cliente cliente;

        if (0 >= id) {
            return "redirect:listar";
        }

        cliente = clienteSrv.findOne(id);
        model.put("titulo", "Editar de cliente");
        model.put("cliente", cliente);
        return "form";
    }

    @PostMapping("form")
    public String guardar(@Valid Cliente cliente, BindingResult result, SessionStatus status) {

        if (result.hasErrors())
            return "form";

        clienteSrv.save(cliente);
        status.setComplete();

        return "redirect:/clientes/listar";
    }

    @RequestMapping("eliminar/{id}")
    public String guardar(@PathVariable(value = "id") Long id) {

        if (id > 0)
            clienteSrv.delete(id);

        return "redirect:/clientes/listar";
    }
}
