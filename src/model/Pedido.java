package model;

import java.time.LocalDate;

public class Pedido {
	
	private Integer idpedido;
	private LocalDate data;
	private String descricao;
	private Integer situacao;
	private Usuario usuario;
	private Local local;
	private Setor setor;
	private String resolucao;
	
	private LocalDate dataModificacao;
	private Usuario responsavel;
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalDate getDataModificacao() {
		return dataModificacao;
	}
	public void setDataModificacao(LocalDate dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	public Usuario getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}
	public Pedido(){
		this.situacao = 0;
	}
	public Pedido(LocalDate data, String descricao, Integer situacao, Usuario usuario, Local local, Setor setor){
	this.data = data;
	this.descricao = descricao;
	this.situacao = situacao;
	this.usuario = usuario;
	this.local = local;
	this.setor = setor;
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
		return data;
	}
	public void setDatahora(LocalDate data) {
		this.data = data;
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
	public String getResolucao() {
		return resolucao;
	}
	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}
}