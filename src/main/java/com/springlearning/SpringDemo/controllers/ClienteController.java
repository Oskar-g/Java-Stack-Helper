package com.springlearning.SpringDemo.controllers;

import com.springlearning.SpringDemo.models.dao.IClienteDao;
import com.springlearning.SpringDemo.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("clientes")
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    @Qualifier("clienteDaoJPA")
    private IClienteDao clienteDao;

    @RequestMapping("listar")
    public String listart(ModelMap model) {
        model.put("titulo", "Listado de clientes");
        model.put("clientes", clienteDao.findAll());
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

        cliente = clienteDao.findOne(id);
        model.put("titulo", "Editar de cliente");
        model.put("cliente", cliente);
        return "form";
    }

    @PostMapping("form")
    public String guardar(@Valid Cliente cliente, BindingResult result, SessionStatus status) {

        if (result.hasErrors())
            return "form";

        clienteDao.save(cliente);
        status.setComplete();
        return "redirect:/clientes/listar";
    }

    @RequestMapping("eliminar/{id}")
    public String guardar(@PathVariable(value = "id") Long id) {

        if (id > 0)
            clienteDao.delete(id);

        return "redirect:/clientes/listar";
    }
}
