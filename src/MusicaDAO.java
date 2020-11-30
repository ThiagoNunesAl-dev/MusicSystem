import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO {

    // Variável com a conexão com o banco de dados
    private Connection connection;


    // Criação da Classe DAO, com a conexão do BD passada como parâmetro
    public MusicaDAO(Connection connection) {
        this.connection = connection;
    }


    // Retorna uma lista com todas as musicas no banco de dados
    public List<String> getLista() {
        try {
            List<String> musicas = new ArrayList<String>();

            PreparedStatement stmt = this.connection.prepareStatement("select * from musica ORDER BY NOTA_MUSICA DESC");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Criando e populando os objetos Musica
                Musica musica = new Musica();
                musica.setNome(rs.getString("NOME_MUSICA"));
                musica.setNota(rs.getFloat("NOTA_MUSICA"));

                // Adicionando o objeto à lista
                musicas.add(musica.getNome().toString());
                musicas.add(musica.getNota().toString());    
            }
            rs.close();
            stmt.close();

            return musicas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Retorna uma música do banco de dados com o nome especificado
    public Musica seleciona(String nome) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from musica where NOME_MUSICA=?");

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            // Criando o objeto Musica
            Musica musica = new Musica();

            while (rs.next()) {
                // Populando o único objeto Musica
                musica.setId(rs.getInt("ID_MUSICA"));
                musica.setNome(rs.getString("NOME_MUSICA"));
                musica.setNota(rs.getFloat("NOTA_MUSICA"));
            }
            rs.close();
            stmt.close();

            return musica;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Adiciona a música no banco de dados e retorna o próprio usuário com o ID atrelado
    public Musica adiciona(Musica musica) {
        String sql = "insert into musica (NOME_MUSICA, NOTA_MUSICA) values (?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, musica.getNome());
            stmt.setFloat(2, musica.getNota());

            stmt.execute();
            stmt.close();

            return musica;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Altera uma música no banco de dados
    public void altera(Musica musica) {
        String sql = "update musica set nome_musica=?, nota_musica=? where id_musica=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, musica.getNome());
            stmt.setFloat(2, musica.getNota());
            stmt.setInt(3, musica.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Remove uma música do banco de dados
    public void remove(Musica musica) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from musica where NOME_MUSICA=?");
            stmt.setString(1, musica.getNome());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}