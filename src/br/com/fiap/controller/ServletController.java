package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.beans.Cachorro;
import br.com.fiap.beans.Carro;
import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Pessoa;
import br.com.fiap.bo.CachorroBO;
import br.com.fiap.bo.CarroBO;
import br.com.fiap.bo.EnderecoBO;
import br.com.fiap.bo.PessoaBO;


@WebServlet("/servletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "index":
			
			listarPessoas(request, response);
			request.getRequestDispatcher(acao + ".jsp").forward(request, response);
			break;
			
		case "pessoa":
			
			int codigoPessoa = Integer.parseInt(request.getParameter("codigo"));
			buscarPessoa(codigoPessoa, request, response);
			listarPessoas(request, response);
			
			String nome = verificarNome(codigoPessoa);
			
			request.setAttribute("nome", nome);
			request.getRequestDispatcher(nome + ".jsp").forward(request, response);
			break;
			
		case "delorean":
			buscarCarro(1, request, response);
			listarPessoas(request, response);
			request.getRequestDispatcher(acao + ".jsp").forward(request, response);
			break;
			
		case "primeiro_viajante":
			buscarCachorro(1, request, response);
			listarPessoas(request, response);
			request.getRequestDispatcher(acao + ".jsp").forward(request, response);
			break;
			
		case "erro":
			listarPessoas(request, response);
			request.getRequestDispatcher(acao + ".jsp").forward(request, response);
			break;
		
		}
	}
	
	
	public void listarPessoas(HttpServletRequest request, HttpServletResponse response) {
		PessoaBO pessoaBO = new PessoaBO();
		List<Pessoa> pessoas = pessoaBO.listar();
		request.setAttribute("pessoas", pessoas);
	}
	
	
	public void buscarPessoa(int codigoPessoa, HttpServletRequest request, HttpServletResponse response) {
		PessoaBO pessoaBO = new PessoaBO();
		Pessoa pessoa;
		try {
			pessoa = pessoaBO.buscar(codigoPessoa);
		} catch (Exception e) {
			pessoa = new Pessoa();
			System.err.println("Erro ao buscar a pessoa no banco: " + e.getMessage());
		}
		request.setAttribute("pessoa", pessoa);
		
		buscarEndereco(pessoa.getEndereco().getCodigo(), request, response);
	}
	
	public void buscarEndereco(int codigoEndereco, HttpServletRequest request, HttpServletResponse response) {
		EnderecoBO enderecoBO = new EnderecoBO();
		Endereco endereco;
		try {
			endereco = enderecoBO.buscar(codigoEndereco);
		} catch (Exception e) {
			endereco = new Endereco();
			System.err.println("Erro ao buscar o endereco no banco: " + e.getMessage());
		}
		request.setAttribute("endereco", endereco);
	}
	
	public void buscarCarro(int codigoCarro, HttpServletRequest request, HttpServletResponse response) {
		CarroBO carroBO = new CarroBO();
		Carro carro;
		try {
			carro = carroBO.buscar(codigoCarro);
		} catch (Exception e) {
			carro = new Carro();
			System.err.println("Erro ao buscar o carro no banco: " + e.getMessage());
		}
		request.setAttribute("carro", carro);
		
		buscarPessoa(carro.getDono().getCodigo(), request, response);
	}
	
	public void buscarCachorro(int codigoCachorro, HttpServletRequest request, HttpServletResponse response) {
		CachorroBO cachorroBO = new CachorroBO();
		Cachorro cachorro;
		try {
			cachorro = cachorroBO.buscar(codigoCachorro);
		} catch (Exception e) {
			cachorro = new Cachorro();
			System.err.println("Erro ao buscar o cachorro no banco: " + e.getMessage());
		}
		request.setAttribute("cachorro", cachorro);
		
		buscarPessoa(cachorro.getDono().getCodigo(), request, response);
	}
	
	public String verificarNome(int codigoPessoa) {
		
		String nome = "";
		
		switch (codigoPessoa) {
		case 1:
			nome = "marty";
			break;
			
		case 2:
			nome = "emmett";
			break;
			
		case 3:
			nome = "george";
			break;
			
		case 4:
			nome = "lorraine";
			break;
			
		case 5:
			nome = "biff";
			break;
		} 
		
		return nome;
	}


}
