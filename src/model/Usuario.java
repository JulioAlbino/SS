package model;

import dao.factory.DaoFactory;


public class Usuario{
	private String nome, senha, login;
	private Integer idusuario;
	private Cargo cargo;
	
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Usuario(Integer idusuario) {
		super();
		
		Usuario retornado = DaoFactory.get().getUsuarioDAO().buscar(idusuario);
		this.idusuario = idusuario;
		this.nome = retornado.getNome();
		this.senha = retornado.getSenha();
		this.login = retornado.getLogin();
		this.cargo = retornado.getCargo();
	}
	
	public Usuario() {
	}
	
	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
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
	
	public String toString(){
		return "Id: "+ this.idusuario + " | Nome: " + this.nome;
	}
	
}
