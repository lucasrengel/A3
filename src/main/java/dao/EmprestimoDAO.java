package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;
import modelo.Emprestimo;
import modelo.Ferramenta;

public class EmprestimoDAO {

    //transforma os IDs em objetos
    AmigoDAO amigoDAO = new AmigoDAO();
    FerramentaDAO ferramentaDAO = new FerramentaDAO();
    public static ArrayList<Emprestimo> minhaLista = new ArrayList<>();

    public ArrayList getMinhaLista() {

        minhaLista.clear();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos");

            while (res.next()) {
                int id = res.getInt("id");
                Amigo amigo = amigoDAO.carregaAmigo(res.getInt("id_amigo"));
                Ferramenta ferramenta = ferramentaDAO.carregaFerramenta(res.getInt("id_ferramenta"));
                java.sql.Date dataEmprestimo = res.getDate("data_emprestimo");
                java.sql.Date dataDevolucao = res.getDate("data_devolucao");

                Emprestimo objeto = new Emprestimo(id, amigo, ferramenta, dataEmprestimo, dataDevolucao);

                minhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                this.getConexao().close();
            } catch (SQLException e) {
            }
        }

        return minhaLista;
    }

    public void registrarEmprestimo(Emprestimo emprestimo) {
        String sql = "INSERT INTO tb_emprestimos (id_ferramenta, id_amigo, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, emprestimo.getIdAmigo().getId());
            stmt.setInt(2, emprestimo.getIdFerramenta().getId());
            stmt.setDate(3, emprestimo.getDataEmprestimo());
            stmt.setDate(4, emprestimo.getDataDevolucao());

            stmt.execute();
            stmt.close();

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteEmprestimoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    public boolean updateEmprestimoBD(Emprestimo emprestimo) {

        String sql = "UPDATE tb_emprestimos set id_ferramenta = ? ,id_amigo = ? ,data_emprestimo = ?, data_devolucao = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, emprestimo.getIdFerramenta().getId());
            stmt.setInt(2, emprestimo.getIdAmigo().getId());
            stmt.setDate(3, emprestimo.getDataEmprestimo());
            stmt.setDate(4, emprestimo.getDataDevolucao());
            stmt.setInt(5, emprestimo.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Emprestimo carregaEmprestimo(int id) {

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE id = " + id);
            res.next();

            emprestimo.setIdAmigo(amigoDAO.carregaAmigo(res.getInt("id_amigo")));
            emprestimo.setIdFerramenta(ferramentaDAO.carregaFerramenta(res.getInt("id_ferramenta")));
            emprestimo.setDataEmprestimo(res.getDate("data_emprestimo"));
            emprestimo.setDataDevolucao(res.getDate("data_devolucao"));

            stmt.close();

        } catch (SQLException erro) {
        }
        return emprestimo;
    }

    private Connection getConexao() {
        return Conexao.getConexao();
    }
}
