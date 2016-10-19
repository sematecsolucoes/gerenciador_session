package br.com.sematec.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sematec.gerenciador.dao.EmpresaDAO;
import br.com.sematec.gerenciador.modelo.Empresa;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa implements Tarefa {
	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		request.setAttribute("nome", nome);
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}
}
