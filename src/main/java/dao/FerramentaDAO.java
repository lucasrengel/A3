package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Ferramenta;

public class FerramentaDAO {

    public static ArrayList<Ferramenta> minhaLista = new ArrayList<>();
    double custoTotal;

    public ArrayList getMinhaLista() {

        minhaLista.clear();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double custo = res.getDouble("custo");

                Ferramenta objeto = new Ferramenta(id, nome, marca, custo);

                minhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return minhaLista;

    }

    //cadastra nova ferramenta
    public boolean insertFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO tb_ferramentas(id,nome,marca,custo)VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCusto());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);

        }
    }

    //deleta uma ferramenta pelo seu id
    public boolean deleteFerramentaBD(int id) {

        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_ferramentas WHERE id =" + id);

            stmt.close();

        } catch (SQLException erro) {
        }
        return true;
    }

    //edita as informacoes de uma ferramenta pelo seu id
    public boolean updateFerramentaBD(Ferramenta objeto) {

        String sql = "UPDATE tb_ferramentas set nome = ? ,marca = ? ,custo = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getCusto());
            stmt.setInt(4, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public double getTotal() {
        ResultSet res;

        try {
            Statement stmt = this.getConexao().createStatement();
            res = stmt.executeQuery("SELECT SUM(custo) FROM tb_ferramentas");
            if (res.next()) {
                custoTotal = res.getDouble("SUM(custo)");
            }
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        } finally {
            try {
                this.getConexao().close();
            } catch (Exception e) {
            }
        }

        return custoTotal;
    }

    //carrega as informacoes da ferramenta pelo id
    public Ferramenta carregaFerramenta(int id) {

        Ferramenta objeto = new Ferramenta();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE id = " + id);
            res.next();

            objeto.setId(id);
            objeto.setNome(res.getString("nome"));
            objeto.setMarca(res.getString("marca"));
            objeto.setCusto(res.getDouble("custo"));

            stmt.close();

        } catch (SQLException erro) {
        }
        return objeto;
    }

    private Connection getConexao() {
        return Conexao.getConexao();
    }
}
