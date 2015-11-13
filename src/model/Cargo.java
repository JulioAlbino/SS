package model;

public class Cargo {

	private Integer Idcargo;
	private String nome;
	private Setor setor;
	
	public Cargo(Integer idcargo, String nome, Setor setor) {
		Idcargo = idcargo;
		this.nome = nome;
		this.setor = setor;
	}

	public Cargo(){
		
	}
	
	public Integer getIdcargo() {
		return Idcargo;
	}
	public void setIdcargo(Integer idcargo) {
		Idcargo = idcargo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String toString() {  
	    return nome;  
	}  


}
