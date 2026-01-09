import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriadorTabela {
    public static void main(String[] args){
        try (Connection conexao = ConexaoDB.conectar();
             Statement stmt = conexao.createStatement()) {

            // definindo o comando sql para criar a tabela
            String comandoSql = "CREATE TABLE produtos (" +
                    "id_produto INT AUTO_INCREMENT PRIMARY KEY," +
                    "nome_produto VARCHAR(100) NOT NULL," +
                    "quantidade INT," +
                    "preco DOUBLE," +
                    "status VARCHAR(50)" +
                    ");";
            System.out.println(comandoSql);

            //Executando o comandoSql
            stmt.execute(comandoSql);

            System.out.println("Tabela 'Produtos' criada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela: " + e.getMessage());
            e.printStackTrace();
        }
    }
}