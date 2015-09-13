package model;

import dao.factory.DaoFactory;
import daoo.UsuarioDAO;

public class Usuario{
	private String nome, senha, login;
	private Integer idusuario;
	private Integer cargo_idcargo;
	private Integer cargo_setor_idsetor;
	
	public Usuario(Integer idusuario) {
		super();
		UsuarioDAO usuarioDao = DaoFactory.get().getUsuarioDAO();
		Usuario retornado = usuarioDao.buscar(idusuario);
		this.idusuario = idusuario;
		this.nome = retornado.getNome();
		this.senha = retornado.getSenha();
		this.login = retornado.getLogin();
		this.cargo_idcargo = retornado.getCargo_idcargo();
		this.cargo_setor_idsetor = retornado.getCargo_setor_idsetor();
	}
	
	public Usuario() {
	}
	
	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getCargo_idcargo() {
		return cargo_idcargo;
	}

	public void setCargo_idcargo(Integer cargo_idcargo) {
		this.cargo_idcargo = cargo_idcargo;
	}

	public Integer getCargo_setor_idsetor() {
		return cargo_setor_idsetor;
	}

	public void setCargo_setor_idsetor(Integer cargo_setor_idsetor) {
		this.cargo_setor_idsetor = cargo_setor_idsetor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}
