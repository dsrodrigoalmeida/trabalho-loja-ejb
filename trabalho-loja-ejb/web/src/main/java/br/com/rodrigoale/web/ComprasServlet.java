package br.com.rodrigoale.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rodrigoale.negocio.biz.dao.ItensCarrinho;

@WebServlet("/carrinho")
public class ComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ControleCompras meuCarrinho;
	private List<ItensCarrinho> lista;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("submit").equals("Adicionar")) {
			meuCarrinho.adicionarProduto(request.getParameter("item"),request.getParameter("qtd"));
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
		}else if (request.getParameter("submit").equals("Finalizar")){
			RequestDispatcher rd = request.getRequestDispatcher("/compraFinalizada.jsp");
			rd.forward(request, response);
		}
	
	}

}
