package com.patrick.crud.resoures;

import com.patrick.crud.dto.ClienteDTO;
import com.patrick.crud.domain.Cidade;
import com.patrick.crud.dto.ClienteNewDTO;
import com.patrick.crud.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.patrick.crud.domain.Cliente;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource  {

    ClienteService clienteService;

    @Autowired
    public ClienteResource(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ClienteDTO> buscarClientes(){
        List<Cliente> clientes = clienteService.buscarClientes();
        List<ClienteDTO> clientesDTO = clientes.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return clientesDTO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cliente buscarPorId(@PathVariable Integer id){
        Cliente cliente = clienteService.buscarPorId(id);
        return cliente;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void inserirCliente(@RequestBody ClienteNewDTO clienteIn){
        Cliente cliente = clienteService.converterDTO(clienteIn);
        clienteService.inserir(cliente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void alterarCliente(@RequestBody String nome, @PathVariable Integer id){
        clienteService.atualizarNome(nome, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar (@PathVariable Integer id){
        clienteService.deletar(id);
    }


}
