package model;

public class Local {
	private Integer id;
	private String nome;
	
	public Local(){
		
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
}
