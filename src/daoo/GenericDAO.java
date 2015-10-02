package daoo;

import java.util.List;

public interface GenericDAO<T> {

	Boolean inserir(T entidade);
	
	Boolean alterar(T entidade);
	
	Boolean excluir(T entidade);
	
	T buscar(Integer id);
	
	List<T> todos();
	
}
