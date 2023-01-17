package com.patrick.crud.services;

import com.patrick.crud.domain.Cidade;
import com.patrick.crud.dto.ClienteDTO;
import com.patrick.crud.dto.ClienteNewDTO;
import com.patrick.crud.repository.CidadeRepository;
import com.patrick.crud.repository.ClienteRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.patrick.crud.domain.Cliente;

import java.util.List;

@Service
public class ClienteService {

    ClienteRepository clienteRepository;
    CidadeRepository cidadeRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository, CidadeRepository cidadeRepository){
        this.clienteRepository = clienteRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public List<Cliente> buscarClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente buscarPorId(Integer id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }

    public void inserir(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deletar(Integer id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.deleteById(id);
    }

    public Cliente atualizarNome(String nome, Integer id) {
        Cliente oldCliente = buscarPorId(id);
        oldCliente.setNome(nome);
        return clienteRepository.save(oldCliente);

    }
    public Cliente converterDTO(ClienteNewDTO clienteIn) {
        Cidade cidade = cidadeRepository.findById(clienteIn.getCidadeId()).orElse(null);
        Cliente cliente = new Cliente(null,clienteIn.getNome(),clienteIn.getCpf(),cidade);
        return cliente;
    }
}
