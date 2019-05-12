package br.com.rodrigoale.web;

import java.io.IOException;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Queue;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.rodrigoale.negocio.biz.dao.Estoque;
import br.com.rodrigoale.negocio.biz.dao.ItensCarrinho;


@JMSDestinationDefinitions(
    value = {
        @JMSDestinationDefinition(
            name = "java:/queue/PedidoRepBean",
            interfaceName = "javax.jms.Queue",
            destinationName = "PedidoRepBean"
        )
        
    }
    
    
)
@WebServlet("/carrinho")
public class ComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ControleCompras meuCarrinho;

	@Inject
	private ControleProduto meuEstoque;

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:/queue/PedidoRepBean")
	private Queue queue;

	private List<ItensCarrinho> lista;
	String pedidoRep = "";

	Destination destination;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("submit").equals("Adicionar")) {
			meuCarrinho.adicionarProduto(request.getParameter("item"), request.getParameter("qtd"));
			lista = meuCarrinho.getCarrinho();
			request.setAttribute("carrinhos", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/listaCarrinho.jsp");
			rd.forward(request, response);

		} else if (request.getParameter("submit").equals("Remover")) {
			meuCarrinho.removerProduto(request.getParameter("radio"));
			lista = meuCarrinho.getCarrinho();
			request.setAttribute("carrinhos", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/listaCarrinho.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("submit").equals("Finalizar")) {

			lista = meuCarrinho.getCarrinho();
			int qtdFaltante;
			for (int i = 0; i < lista.size(); i++) {
				Estoque estoque = meuEstoque.selecionarProdutoDoEstoque(lista.get(i).getProduto().getId());
					System.out.println("Recebendo pedido de: " + lista.get(i).getProduto().getNome() + " quantidade: " + lista.get(i).getQtdCarrinho());;
					qtdFaltante = lista.get(i).getQtdCarrinho() - estoque.getQtdEstoque();
					if (qtdFaltante > 0) {
					pedidoRep += "id:" + estoque.getProduto().getId()  +":nome:"+estoque.getProduto().getNome()+":qtd:" + qtdFaltante+":";
					estoque.setQtdEstoque(qtdFaltante);
					destination = queue;

					context.createProducer().send(destination, pedidoRep);
					pedidoRep="";
					}else {
						meuEstoque.alterarEstoque(estoque.getProduto().getId(), Math.abs(qtdFaltante));
					}
					
			}
			meuCarrinho.limparCarrinho();
			
			response.sendRedirect("/loja/compraFinalizada.jsp");

		}

	}

}
