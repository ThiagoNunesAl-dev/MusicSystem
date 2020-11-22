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


    // Retorna uma lista com todas as musicas no banco de dados
    public List<GeneroMusica> getLista() {
        try {
            List<GeneroMusica> generoMusicas = new ArrayList<GeneroMusica>();

            PreparedStatement stmt = this.connection.prepareStatement("select * from genero_musica");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Criando e populando os objetos Musica
                GeneroMusica generoMusica = new GeneroMusica();
                generoMusica.setId(rs.getInt("ID_GENERO"));
                generoMusica.setNome(rs.getString("NOME_GENERO"));

                // Adicionando o objeto à lista
                generoMusicas.add(generoMusica);
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
            PreparedStatement stmt = this.connection.prepareStatement("select * from genero_musica where NOME_GENERO=?");

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

    // Adiciona a música no banco de dados e retorna o próprio usuário com o ID atrelado
    public GeneroMusica adiciona(GeneroMusica generoMusica) {
        String sql = "insert into genero_musica " +
                "(nome_genero) " +
                "values (?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, generoMusica.getNome());


            stmt.execute();

            // Segunda string para recuperar o objeto usuário do banco
            String sqlSelect = "select * from genero_musica where NOME_GENERO=?";
            PreparedStatement stmtSelect = this.connection.prepareStatement(sqlSelect);
            stmtSelect.setString(1, generoMusica.getNome());

            ResultSet rs = stmtSelect.executeQuery();


            while (rs.next()) {
                // criando o objeto Usuario
                generoMusica.setId(rs.getInt("ID_GENERO"));
                generoMusica.setNome(rs.getString("NOME_GENERO"));
            }

            rs.close();
            stmt.close();
            stmtSelect.close();

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
            PreparedStatement stmt = connection.prepareStatement("delete from genero_musica where id_genero=?");
            stmt.setInt(1, generoMusica.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}