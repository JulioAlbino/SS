package model;

public class Setor {

	private String nome;
	private Integer idsetor;
	
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
	
	public Setor (String nome, Integer id){
		this.idsetor = id;
		this.nome = nome;
	}
	
	public String toString() {  
	    return getNome();  
	}  
	
}
