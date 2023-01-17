package com.patrick.crud;

import com.patrick.crud.domain.Cidade;
import com.patrick.crud.domain.Cliente;
import com.patrick.crud.repository.CidadeRepository;
import com.patrick.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DesafioCrudApplication implements CommandLineRunner {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    CidadeRepository cidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DesafioCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Cidade c1 = new Cidade(null,"Rio de Janeiro");
        Cidade c2 = new Cidade(null,"São Paulo");

        Cliente cliente1 = new Cliente(null,"João","1111111",c1);
        Cliente cliente2 = new Cliente(null,"Maria","2222222",c1);
        Cliente cliente3 = new Cliente(null,"Mário","33333333",c2);

        cidadeRepository.saveAll(Arrays.asList(c1, c2));
        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));

    }
}
