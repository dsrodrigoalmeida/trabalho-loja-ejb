package br.com.rodrigoale.loja;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.rodrigoale.loja.domain.Cliente;
import br.com.rodrigoale.loja.domain.Estoque;
import br.com.rodrigoale.loja.repositories.ClienteRepository;
import br.com.rodrigoale.loja.repositories.EstoqueRepository;

@SpringBootApplication
public class QualquerCoisaApplication implements CommandLineRunner {

	
	
	@Autowired
	EstoqueRepository estoqueRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(QualquerCoisaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estoque produto = new Estoque(null, "queijo", 10, 15.0);
		Estoque produto2 = new Estoque(null, "chocolate", 3, 5.0);
		Estoque produto3 = new Estoque(null, "café", 5, 3.0);
		Estoque produto4 = new Estoque(null, "pepsi", 10, 3.9);
		Estoque produto5 = new Estoque(null, "chá", 6, 2.5);
		Estoque produto6 = new Estoque(null, "biscoito", 8, 1.5);
		Estoque produto7 = new Estoque(null, "lembas", 15, 12.0);
		Estoque produto8 = new Estoque(null, "hidromel", 30, 15.0);
		Estoque produto9 = new Estoque(null, "vinho", 28, 25.0);
		Estoque produto10 = new Estoque(null, "agua", 50, 2.3);
		
		
		Cliente cliente = new Cliente(null,"princesazelda","zelda");
		Cliente cliente2 = new Cliente(null,"link","link");
		Cliente cliente3 = new Cliente(null,"ganon","calamity ganon");
		Cliente cliente4 = new Cliente(null,"legolas","legolas verdefolha");
		Cliente cliente5 = new Cliente(null,"aragorn","aragorn passolargo");
		Cliente cliente6 = new Cliente(null,"gimli","gimli filho de glóin ");
		Cliente cliente7 = new Cliente(null,"gandalf","gandalf o cinzento ");
		Cliente cliente8 = new Cliente(null,"bilbo","bilbo bolseiro ");
		Cliente cliente9 = new Cliente(null,"teste","123 ");
		Cliente cliente10 = new Cliente(null,"rodrigo","rodrigo almeida ");
		
		estoqueRepository.saveAll(Arrays.asList(produto, produto2, produto3, produto4,produto5,produto6,produto7,produto8,produto9,produto10));
		clienteRepository.saveAll(Arrays.asList(cliente,cliente2,cliente3,cliente4,cliente5,cliente6,cliente7,cliente8,cliente9,cliente10));
	}

}
