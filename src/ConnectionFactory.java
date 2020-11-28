import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String usuario = "sa";
	String senha = "sa132";
	String url = "jdbc:sqlserver://THIAGO-PC:1433;instanceName=SQLEXPRESS;databaseName=Espotifai";
	
	public Connection obterConexao() {
		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			return conexao;
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro: ");
			e.printStackTrace();
			return null;
		}
	}	
}