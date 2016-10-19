package br.com.sematec.gerenciador.web;

import java.util.Collection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sematec.gerenciador.dao.EmpresaDAO;
import br.com.sematec.gerenciador.modelo.Empresa;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa implements Tarefa {
	public BuscaEmpresa() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa "
				+ this);
	}

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		String filtro = request.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO()
		.buscaPorSimilaridade(filtro);
		request.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}
}
