package com.springlearning.SpringDemo.models.services;

import com.springlearning.SpringDemo.models.entity.Cliente;

import java.util.List;

public interface IClienteSrv {
    List<Cliente> findAll();

    Cliente findOne(long id);

    void save(Cliente cliente);

    void delete(long id);
}
