import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    public static Connection conectar() {
        try {
            // Força o carregamento do driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/projeto_java?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String usuario = "root";   // seu usuário do MySQL
            String senha = "1811"; // sua senha configurada no Workbench

            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC do MySQL não encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}
