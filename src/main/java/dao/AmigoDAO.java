package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;

// Classe DAO (Data Access Object) para a entidade Amigo, contendo métodos para realizar operações de CRUD no banco de dados.
public class AmigoDAO {

    public static ArrayList<Amigo> minhaLista = new ArrayList<>();

    //retorna a lista de amigos
    public ArrayList getMinhaLista() {

        minhaLista.clear();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String telefone = res.getString("telefone");

                Amigo objeto = new Amigo(id, nome, telefone);

                minhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return minhaLista;
    }

    //cadastra um novo amigo com o objeto criado
    public boolean insertAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO tb_amigos(id,nome,telefone) VALUES(?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    //deleta um amigo pelo seu id
    public boolean deleteAmigoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_amigos WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    //atualiza um amigo com o objeto criado
    public boolean updateAmigoBD(Amigo objeto) {

        String sql = "UPDATE tb_amigos set nome = ? ,telefone = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTelefone());
            stmt.setInt(3, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    //carrega as informacoes do amigo pelo id
    public Amigo carregaAmigo(int id) {

        Amigo objeto = new Amigo();
        objeto.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getString("telefone"));

            stmt.close();

        } catch (SQLException erro) {
        }
        return objeto;
    }
    
    //retorna o amigo com mais emprestimos
    public Amigo getAmigoComMaisEmprestimos() {
        Amigo amigoComMaisEmprestimos = null;
        int maxEmprestimos = 0;

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT id_amigo, COUNT(*) as total_emprestimos FROM tb_emprestimos GROUP BY id_amigo ORDER BY total_emprestimos DESC LIMIT 1");

            if (res.next()) {
                int idAmigo = res.getInt("id_amigo");
                int totalEmprestimos = res.getInt("total_emprestimos");

                amigoComMaisEmprestimos = carregaAmigo(idAmigo);
                maxEmprestimos = totalEmprestimos;
            }

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                this.getConexao().close();
            } catch (Exception e) {
            }
        }

        if (amigoComMaisEmprestimos != null) {
            amigoComMaisEmprestimos.setTotalEmprestimos(maxEmprestimos);
        }

        return amigoComMaisEmprestimos;
    }

    //metodo para se conectar ao banco de dados
    private Connection getConexao() {
        return Conexao.getConexao();
    }
}
