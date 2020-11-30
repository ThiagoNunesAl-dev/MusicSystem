import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Variável com a conexão com o banco de dados
    private Connection connection;

    // Criação da Classe DAO, com a conexão do BD passada como parâmetro
    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    
    // Retorna uma lista com todos os usuários no banco de dados
    public List<Usuario> getLista() {
        try {
            List<Usuario> usuarios = new ArrayList<Usuario>();

            PreparedStatement stmt = this.connection.prepareStatement("select * from usuario");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Criando e populando os objetos Usuario
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME_USUARIO"));
                usuario.setSenha(rs.getString("SENHA_USUARIO"));

                // Adicionando o objeto à lista
                usuarios.add(usuario);
            }
            rs.close();
            stmt.close();

            return usuarios;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Retorna o usu�rio do banco de dados com o nome especificado
    public Usuario seleciona(String nome) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where NOME=?");

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            // Criando o objeto Usuario
            Usuario usuario = new Usuario();

            while (rs.next()) {
                // Populando o objeto Usuario
                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setNome(rs.getString("NOME_USUARIO"));
                usuario.setSenha(rs.getString("SENHA_USUARIO"));
            }
            rs.close();
            stmt.close();

            return usuario;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Adiciona o usuário no banco de dados e retorna o próprio usuário com o ID atrelado
    public Usuario adiciona(Usuario usuario) {
        String sql = "insert into usuario (NOME_USUARIO, SENHA_USUARIO) values (?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());

            stmt.execute();
            stmt.close();

            return usuario;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Altera um USU�RIO no banco de dados
    public void altera(Usuario usuario) {
        String sql = "update usuario set nome_usuario=?, senha_usuario=? where id_usuario=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Remove um usuário do banco de dados
    public void remove(Usuario usuario) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from usuario where id_usuario=?");
            stmt.setInt(1, usuario.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}