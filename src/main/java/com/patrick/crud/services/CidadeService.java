package com.patrick.crud.services;

import com.patrick.crud.domain.Cidade;
import com.patrick.crud.domain.Cliente;
import com.patrick.crud.repository.CidadeRepository;
import com.patrick.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    CidadeRepository cidadeRepository;
    ClienteRepository clienteRepository;
    @Autowired
    public CidadeService(CidadeRepository cidadeRepository, ClienteRepository clienteRepository){
        this.cidadeRepository = cidadeRepository;
        this.clienteRepository = clienteRepository;
    }
    public void cadastrar(Cidade cidadein) {
        cidadeRepository.save(cidadein);
    }

    public List<Cidade> buscar() {
        return cidadeRepository.findAll();
    }

    public List<Cliente> buscarCliente(Integer id) {
        Cidade cidade = cidadeRepository.findById(id).orElse(null);
        return clienteRepository.findByCidade(cidade);
    }
}
