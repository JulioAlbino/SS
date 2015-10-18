package model;

import java.time.LocalDate;

public class Pedido {
	
	private Integer idpedido;
	private LocalDate datahora;
	private String descricao;
	private Integer situacao;
	private Usuario usuario;
	private Local local;
	private Setor setor;
	
	public Pedido(){
		
	}
	public String toString(){
		return descricao;
	}
	
	public Integer getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}
	public LocalDate getDatahora() {
		return datahora;
	}
	public void setDatahora(LocalDate datahora) {
		this.datahora = datahora;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getSituacao() {
		return situacao;
	}
	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}


}
