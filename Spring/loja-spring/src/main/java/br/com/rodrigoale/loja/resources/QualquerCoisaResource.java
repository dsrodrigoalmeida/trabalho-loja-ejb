package br.com.rodrigoale.loja.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.rodrigoale.loja.domain.Cliente;
import br.com.rodrigoale.loja.domain.Estoque;
import br.com.rodrigoale.loja.domain.Item;
import br.com.rodrigoale.loja.domain.Pedido;
import br.com.rodrigoale.loja.domain.Reposicao;
import br.com.rodrigoale.loja.domain.enums.StatusPedido;
import br.com.rodrigoale.loja.domain.enums.StatusReposicao;
import br.com.rodrigoale.loja.services.ClienteService;
import br.com.rodrigoale.loja.services.EstoqueService;
import br.com.rodrigoale.loja.services.PedidoService;
import br.com.rodrigoale.loja.services.ReposicaoService;

@RestController
@RequestMapping(value = "/qualquercoisa")
public class QualquerCoisaResource {

	@Autowired
	private EstoqueService estoqueService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private ReposicaoService reposicaoService;

	private List<Item> carrinho = new ArrayList<>();

	private Cliente cliente;
	private Pedido pedido;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView pagina_login() {

		ModelAndView modelAndView = new ModelAndView("login");

		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginCliente(@RequestParam("nomeusuario") String nomeUsuario) {
		if (cliente != null) {
			cliente = null;
		}
		Cliente obj = clienteService.findByNomeUsuario(nomeUsuario);

		if (obj == null) {
			System.out.println("login invalido");
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
		}

		cliente = obj;

		ModelAndView modelAndView = new ModelAndView("index");

		return modelAndView;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView("index");

		return modelAndView;
	}

	@RequestMapping(value = "/paginabuscaproduto", method = RequestMethod.GET)
	public ModelAndView pagina_busca_produto() {

		ModelAndView modelAndView = new ModelAndView("buscaproduto");

		return modelAndView;
	}

	@RequestMapping(value = "/buscaproduto", method = RequestMethod.GET)
	public ModelAndView buscaProduto(@RequestParam("nomeproduto") String nomeProduto) {
		List<Estoque> obj = estoqueService.findByNomeContaining(nomeProduto);
		ModelAndView modelAndView = new ModelAndView("listaprodutos");

		modelAndView.addObject("produtos", obj);

		return modelAndView;
	}

	@RequestMapping(value = "/paginacadastraproduto", method = RequestMethod.GET)
	public ModelAndView pagina_cadastra_produto() {

		ModelAndView modelAndView = new ModelAndView("cadastraproduto");

		return modelAndView;
	}

	@RequestMapping(value = "/cadastraproduto", method = RequestMethod.POST)
	public ModelAndView cadastraProduto(@RequestParam("nome") String nome,
			@RequestParam("quantidade") Integer quantidade, @RequestParam("valor") Double valor) {

		Estoque produto = estoqueService.findByNome(nome);

		if (produto == null) {
			produto = new Estoque(null, nome, quantidade, valor);
			estoqueService.insert(produto);
			System.out.println("produto " + produto.getNome() + " cadastrado com sucesso!");
		} else {
			System.out.println("Esse produto ja existe");
		}
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@RequestMapping(value = "/listaprodutoestoque", method = RequestMethod.GET)
	public ModelAndView listaProdutoEstoque() {
		List<Estoque> obj = estoqueService.findAll();
		ModelAndView modelAndView = new ModelAndView("listaestoque");

		modelAndView.addObject("produtos", obj);

		return modelAndView;
	}

	@RequestMapping(value = "/paginaatualizaproduto", method = RequestMethod.GET)
	public ModelAndView pagina_atualizaa_produto() {

		ModelAndView modelAndView = new ModelAndView("atualizaproduto");

		return modelAndView;
	}

	@RequestMapping(value = "/atualizaproduto", method = RequestMethod.POST)
	public ModelAndView atualizaProduto(@RequestParam("nome") String nome,
			@RequestParam("quantidade") Integer quantidade, @RequestParam("valor") Double valor) {

		Estoque produtoOriginal = estoqueService.findByNome(nome);

		if (produtoOriginal != null) {
			Estoque produtoNovo = new Estoque(produtoOriginal.getIdProduto(), nome, quantidade, valor);
			estoqueService.insert(produtoNovo);
			System.out.println("Produto "+ produtoNovo.getNome() +" atualizado com sucesso");

		} else {
			System.out.println("Não trabalhamos com esse produto!");
		}
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@RequestMapping(value = "/adicionacarrinho", method = RequestMethod.POST)
	public ModelAndView adicionaCarrinho(@RequestParam("radio") Integer idProduto,
			@RequestParam("quantidadecompra") Integer quantidadeCompra) {
		boolean repetido = false;
		Estoque produto = estoqueService.findByIdProduto(idProduto);
		if (carrinho.size() > 0) {
			for (int i = 0; i < carrinho.size(); i++) {
				if (produto.getNome().equals(carrinho.get(i).getNome())) {
					Integer quantidadeAtualizada = carrinho.get(i).getQuantidade() + quantidadeCompra;
					carrinho.get(i).setQuantidade(quantidadeAtualizada);
					repetido = true;
					break;

				}
			}
		}

		if (repetido == false | carrinho.size() == 0) {
			carrinho.add(new Item(null, produto.getNome(), quantidadeCompra, produto.getValor()));

		}
		ModelAndView modelAndView = new ModelAndView("carrinho");
		modelAndView.addObject("carrinho", carrinho);
		return modelAndView;
	}

	@RequestMapping(value = "/removecarrinho", method = RequestMethod.POST)
	public ModelAndView removeCarrinho(@RequestParam("radio") String nome) {
		for (int i = 0; i < carrinho.size(); i++) {
			if (nome.equals(carrinho.get(i).getNome())) {
				carrinho.remove(i);
				break;
			}
		}
		ModelAndView modelAndView = new ModelAndView("carrinho");
		modelAndView.addObject("carrinho", carrinho);
		return modelAndView;
	}

	@RequestMapping(value = "/listacarrinho", method = RequestMethod.GET)
	public ModelAndView listaCarrinho() {

		ModelAndView modelAndView = new ModelAndView("carrinho");
		modelAndView.addObject("carrinho", carrinho);
		return modelAndView;
	}

	@RequestMapping(value = "/paginacadastracliente", method = RequestMethod.GET)
	public ModelAndView pagina_cadastra_cliente() {

		ModelAndView modelAndView = new ModelAndView("cadastracliente");

		return modelAndView;
	}

	@RequestMapping(value = "/cadastracliente", method = RequestMethod.POST)
	public ModelAndView cadastraProduto(@RequestParam("nomeusuario") String nomeUsuario,
			@RequestParam("nomecliente") String nomeCliente) {

		Cliente cliente = clienteService.findByNomeUsuario(nomeUsuario);

		if (cliente == null) {
			cliente = new Cliente(null, nomeUsuario, nomeCliente);
			clienteService.insert(cliente);
			System.out.println("cliente " + cliente.getNomeUsuario() + " cadastrado com sucesso!");
		} else {
			System.out.println("Esse nome de usuario ja existe");
		}
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@RequestMapping(value = "/finalizapedido", method = RequestMethod.GET)
	public ModelAndView finalizaPedido() {

		Reposicao reposicao = null;

		List<Item> reposicaoLista = new ArrayList<>();
		for (int i = 0; i < carrinho.size(); i++) {
			Item produto_carrinho = carrinho.get(i);
			Estoque produto_estoque = estoqueService.findByNome(produto_carrinho.getNome());
			Integer qtdAtualizada = produto_estoque.getQuantidade() - produto_carrinho.getQuantidade();

			if (qtdAtualizada < 0) {
				Integer frep = 1 + ((int) (Math.random() * 3));
				Integer qtdFrep = 1 + (frep * Math.abs(qtdAtualizada));
				Item produto_reposicao = new Item(null, produto_estoque.getNome(), qtdFrep, produto_estoque.getValor());
				reposicaoLista.add(produto_reposicao);
			}

			produto_estoque.setQuantidade(qtdAtualizada);
			estoqueService.insert(produto_estoque);

		}

		if (reposicaoLista.size() == 0) {

			pedido = new Pedido(null, StatusPedido.CONCLUIDO, cliente);

		} else {
			pedido = new Pedido(null, StatusPedido.PROCESSANDO, cliente);
			reposicao = new Reposicao(null, StatusReposicao.PROCESSANDO, null);
			reposicao.setProdutos(reposicaoLista);

		}
		pedido.getProdutos().addAll((carrinho));
		pedidoService.insert(pedido);
		clienteService.insert(cliente);
		carrinho.clear();

		if (reposicao != null) {
			reposicao.setPedido(pedido);
			reposicaoService.insert(reposicao);
		}
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping(value = "/listapedido", method = RequestMethod.GET)
	public ModelAndView pagina_lista_pedido() {

		List<Pedido> pedido = pedidoService.findByCliente(cliente);

		ModelAndView modelAndView = new ModelAndView("listapedido");
		modelAndView.addObject("listapedido", pedido);

		return modelAndView;
	}

	@RequestMapping(value = "/cancelapedido", method = RequestMethod.POST)
	public ModelAndView cancelaPedido(@RequestParam("radio") Integer idPedido) {
		Pedido pedido = pedidoService.findByIdPedido(idPedido);
		if (pedido.getStatus().equals(StatusPedido.PROCESSANDO)) {
			for (int i = 0; i < pedido.getProdutos().size(); i++) {
				Item item_pedido = pedido.getProdutos().get(i);
				Estoque produto_estoque = estoqueService.findByNome(item_pedido.getNome());
				Integer novaQuantidade = item_pedido.getQuantidade() + produto_estoque.getQuantidade();
				produto_estoque.setQuantidade(novaQuantidade);
				estoqueService.insert(produto_estoque);
			}
			pedido.setStatus(StatusPedido.CANCELADO);
			pedidoService.insert(pedido);
		} else {
			System.out.println("Erro! Não foi possivel cancelar esse pedido!");
		}
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping(value = "/listareposicao", method = RequestMethod.GET)
	public ModelAndView listaReposicao() {
		List<Reposicao> obj = reposicaoService.findAll();

		ModelAndView modelAndView = new ModelAndView("listareposicao");

		modelAndView.addObject("reposicao", obj);

		return modelAndView;
	}

	@RequestMapping(value = "/processareposicao", method = RequestMethod.POST)
	public ModelAndView processaReposicao(@RequestParam("radio") Integer idReposicao) {
		Reposicao reposicao = reposicaoService.findByIdReposicao(idReposicao);
		if (reposicao.getStatus().equals(StatusReposicao.PROCESSANDO)) {

			for (int i = 0; i < reposicao.getProdutos().size(); i++) {
				Item produto_reposicao = reposicao.getProdutos().get(i);
				Estoque produto = estoqueService.findByNome(produto_reposicao.getNome());
				Integer qtdReposicao = produto.getQuantidade() + produto_reposicao.getQuantidade();
				produto.setQuantidade(qtdReposicao);
				estoqueService.insert(produto);
			}

			Pedido pedido = pedidoService.findByIdPedido(reposicao.getPedido().getIdPedido());
			if (pedido.getStatus().equals(StatusPedido.PROCESSANDO)) {
				pedido.setStatus(StatusPedido.CONCLUIDO);
				pedidoService.insert(pedido);
			}
			reposicao.setStatus(StatusReposicao.CONCLUIDO);
			reposicaoService.insert(reposicao);
		} else {
			System.out.println("Erro! Essa reposição ja foi processada!");
		}
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

}