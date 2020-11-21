import java.sql.Connection;
import java.util.List;

public class MusicSystem {
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try{
            connection = new ConnectionFactory().getConnection();

            System.out.println("Conectado!");

            // criação dos DAOs
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

        }
        catch(Exception e){
            System.out.println(e);
        }
        finally {
            connection.close();
        }
    }
}