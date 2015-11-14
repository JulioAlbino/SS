package model;

import dao.factory.DaoFactory;

public class Local {
	private Integer id;
	private String nome;
	private Boolean ativo = true;
	
	public Local(){
		
	}
	
	public Local(Integer id){
		 Local local = DaoFactory.get().getLocalDAO().buscar(id);
		 this.id = local.getId();
		 this.nome = local.getNome();
		 this.ativo = local.getAtivo();
		 
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString(){
		return this.nome;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
