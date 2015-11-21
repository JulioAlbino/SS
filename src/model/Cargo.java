package model;

public class Cargo {

	private Integer Idcargo;
	private String nome;
	private Setor setor;
	private Boolean ativo = true;
	private Integer permissao;
	
	public Cargo(Integer idcargo, String nome, Setor setor, Boolean ativo, Integer permissao) {
		this.Idcargo = idcargo;
		this.nome = nome;
		this.setor = setor;
		this.ativo = ativo;
		this.setPermissao(permissao);
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getPermissao() {
		return permissao;
	}

	public void setPermissao(Integer permissao) {
		this.permissao = permissao;
	}  


}
