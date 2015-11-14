package model;

import dao.factory.DaoFactory;

public class Setor {

	private String nome;
	private Integer idsetor;
	private Boolean ativo = true;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdsetor() {
		return idsetor;
	}

	public void setIdsetor(Integer idsetor) {
		this.idsetor = idsetor;
	}

	
	public Setor(){
		
	}
	
	public Setor (Integer id){
		Setor setorPego = DaoFactory.get().getSetorDAO().buscar(id);
		this.idsetor = id;
		this.nome = setorPego.getNome();
		this.ativo = setorPego.getAtivo();
	}
	
	public String toString() {  
	    return getNome();  
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}  
	
}
