import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private final Connection CONEXAO_DB;

    //construtor que inicializa a conexao com o banco de dados
    public ProdutoDAO(Connection conexao){
        this.CONEXAO_DB = conexao;
    }

    //metodo para inserir um novo produto no banco de dados
    public void inserir(Produto produto){
        String sql = "INSERT INTO produtos (nome_produto, quantidade, preco, status) VALUES (?, ?, ?, ?";
        try (PreparedStatement stmt = CONEXAO_DB.preparedStatement(sql)){
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getPreco());
            stmt.setString(4, produto.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public void excluirTodos(){
        String sql = "DELETE FROM produtos";
        try (PreparedStatement stmt = CONEXAO_DB.preparedStatement(sql)){
            stmt.executeUpdate();
            stmt.
        } catch (SQLException e) {
            System.err.println("Erro ao excluir todos os produto: " + e.getMessage());
        }
    }

    public Produto consultarPorId (int id) {
        String sql = "SELECT * FROM produtos WHERE id_produto = ?";
        try (PreparedStatement stmt = CONEXAO_DB.preparedStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            stmt.setInt(i, id);
            if( rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setStatus(rs.getStatus("status"));
                return produto;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar produto por ID: " + e.getMessage());
        }
        return null;
    }

    public void atualizar(Produto produto){
        String sql = "UPDATE produtos SET nome_produto = ?, quantidade = ?, preco = ?, status = ? WHERE id_produto = ?";
        try(PreparedeStatemente stmt = CONEXAO_DB.preparedStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getPreco());
            stmt.setString(4, produto.getStatus());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    public void excluir(int id){
        String sql = "DELETE FROM produtos WHERE id_produto = ?";
        try(PreparedeStatemente stmt = CONEXAO_DB.preparedStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir o produto: " + e.getMessage());
        }
    }

    public list<Produto> listarTodos(){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT FROM produtos";
        try(PreparedeStatemente stmt = CONEXAO_DB.preparedStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setStatus(rs.getStatus("status"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }


}