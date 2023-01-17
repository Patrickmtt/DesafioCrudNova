package com.patrick.crud.resoures;

import com.patrick.crud.domain.Cidade;
import com.patrick.crud.domain.Cliente;
import com.patrick.crud.services.CidadeService;
import com.patrick.crud.services.ClienteService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

    CidadeService cidadeService;

    @Autowired
    public CidadeResource(CidadeService cidadeService){
        this.cidadeService = cidadeService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void cadastrarCidade(@Validated @RequestBody Cidade cidadein){
        cidadeService.cadastrar(cidadein);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cidade> buscarCidades(){
        List<Cidade> cidades = cidadeService.buscar();
        return cidades;
    }
    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public List<Cliente> buscarPorCidades(@PathVariable Integer id){
        return cidadeService.buscarCliente(id);

    }
}
