package br.com.sematec.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/fazTudo")
public class FazTudo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		if (tarefa == null) {
			throw new IllegalArgumentException(
					"Você esqueceu de passar a tarefa");
		}
		try {
			String nomeDaClasse = "br.com.sematec.gerenciador.web." + tarefa;
			Class<?> type = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) type.newInstance();
			String pagina = instancia.executa(req, resp);
			RequestDispatcher requestDispatcher = req
					.getRequestDispatcher(pagina);
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
