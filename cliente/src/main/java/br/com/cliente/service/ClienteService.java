package br.com.cliente.service;

import br.com.cliente.entity.Cliente;
import br.com.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    @Transactional
    public Cliente criar(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente buscarPorId(Long id){
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.get();
    }

}
