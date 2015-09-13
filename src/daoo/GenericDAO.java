package daoo;

import java.util.List;

public interface GenericDAO<T> {

	void inserir(T entidade);
	
	void alterar(T entidade);
	
	void excluir(T entidade);
	
	T buscar(Integer id);
	
	List<T> todos();
	
}
