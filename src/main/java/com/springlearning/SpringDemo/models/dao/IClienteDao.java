package com.springlearning.SpringDemo.models.dao;

import com.springlearning.SpringDemo.models.entity.Cliente;

import java.util.List;

public interface IClienteDao {
    List<Cliente> findAll();

    Cliente findOne(long id);

    void save(Cliente cliente);

    void delete(long id);

}
