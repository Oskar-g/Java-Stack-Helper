package com.springlearning.SpringDemo.models.dao;

import com.springlearning.SpringDemo.models.entity.Cliente;

import java.util.List;

public interface IClienteDao {
    List<Cliente> findAll();

    void save(Cliente cliente);

    Cliente findOne(long id);

    void delete(long id);

}
