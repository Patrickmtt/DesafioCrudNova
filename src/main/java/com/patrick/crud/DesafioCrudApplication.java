package com.patrick.crud;

import com.patrick.crud.domain.Cliente;
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


    public static void main(String[] args) {
        SpringApplication.run(DesafioCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente cliente1 = new Cliente("33", "João", "1111111111");
        Cliente cliente2 = new Cliente("25", "Maria", "111111111");
        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
}
}
