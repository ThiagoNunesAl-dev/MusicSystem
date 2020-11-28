import java.sql.Connection;

public class MusicSystem {
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try{
            connection = new ConnectionFactory().obterConexao();

            System.out.println("Conectado! Status: "+connection);

            // criação dos DAOs
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            MusicaDAO musicaDAO = new MusicaDAO(connection);
            GeneroMusicaDAO generoMusicaDAO = new GeneroMusicaDAO(connection);

        }
        catch(Exception e){
            System.out.println(e);
        }
        finally {
            connection.close();
        }
    }
}