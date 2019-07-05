package com.springlearning.SpringDemo.models.dao;

import com.springlearning.SpringDemo.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
