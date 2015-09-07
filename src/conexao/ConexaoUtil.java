package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {

	private static Connection connection;
	
	static {
		String endereco = "jdbc:mysql://localhost:3306/pedido_jdbc";
		String usuario = "root";
		String senha = "";
		try {
			connection = DriverManager.getConnection(endereco, usuario, senha);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar no banco de dados"+e.getMessage());
		}
	}
	
	public static Connection getCon() {
		return connection;
	}
}
