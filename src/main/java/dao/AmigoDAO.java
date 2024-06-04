package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;

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

    //cadastra um novo amigo
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

    //atualiza um amigo pelo seu id
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

    private Connection getConexao() {
        return Conexao.getConexao();
    }
}
