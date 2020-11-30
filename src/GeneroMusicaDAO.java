import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroMusicaDAO {

	// Variável com a conexão com o banco de dados
	private Connection connection;

	// Criação da Classe DAO, com a conexão do BD passada como parâmetro
	public GeneroMusicaDAO(Connection connection) {
		this.connection = connection;
	}

	// Retorna uma lista com todos os g�neros no banco de dados
	public List<String> getLista() {
		try {
			List<String> generoMusicas = new ArrayList<String>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from genero_musica");

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// Criando e populando os objetos G�neros
				GeneroMusica generoMusica = new GeneroMusica();
				// generoMusica.setId(rs.getInt("ID_GENERO"));
				generoMusica.setNome(rs.getString("NOME_GENERO"));

				// Adicionando o objeto à lista
				generoMusicas.add(generoMusica.getNome().toString());
			}
	
			rs.close();
			stmt.close();
            
			return generoMusicas;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	

	// Retorna uma música do banco de dados com o nome especificado
	public GeneroMusica seleciona(String nome) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from genero_musica where NOME_GENERO=?");

			stmt.setString(1, nome);

			ResultSet rs = stmt.executeQuery();

			// Criando o objeto GeneroMusica
			GeneroMusica generoMusica = new GeneroMusica();

			while (rs.next()) {
				// Populando o único objeto GeneroMusica
				generoMusica.setId(rs.getInt("ID_GENERO"));
				generoMusica.setNome(rs.getString("NOME_GENERO"));

			}
			rs.close();
			stmt.close();

			return generoMusica;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Adiciona o g�nero no banco de dados
	public GeneroMusica adiciona(GeneroMusica generoMusica/*, Usuario usuario*/) {
		String sql = "insert into genero_musica (NOME_GENERO) values (?);"/*+
					 "insert into usuario_genero_musica (ID_USUARIO, ID_GENERO) values (?, ?)"*/;

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, generoMusica.getNome());
			//stmt.setInt(2, usuario.getId());
			//stmt.setInt(3, generoMusica.getId());

			stmt.execute();
			stmt.close();

			return generoMusica;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Altera uma música no banco de dados
	public void altera(GeneroMusica generoMusica) {
		String sql = "update genero_musica set nome_genero=? where id_genero=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, generoMusica.getNome());
			stmt.setInt(3, generoMusica.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Remove uma música do banco de dados
	public void remove(GeneroMusica generoMusica) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from genero_musica where NOME_GENERO = ?");
			stmt.setString(1, generoMusica.getNome());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}