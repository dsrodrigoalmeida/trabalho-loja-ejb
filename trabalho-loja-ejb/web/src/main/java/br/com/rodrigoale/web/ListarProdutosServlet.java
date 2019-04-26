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

import br.com.rodrigoale.negocio.biz.dao.Estoque;


@WebServlet("/estoque")
public class ListarProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ControleProduto meuEstoque;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			List<Estoque> lista = meuEstoque.listar();
			
			request.setAttribute("estoques", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/listaProdutos.jsp");
			rd.forward(request, response);
		}

}
