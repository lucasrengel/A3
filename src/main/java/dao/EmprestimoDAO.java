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

    //retorna a lista de emprestimos
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

    //registra um emprestimo a partir do objeto criado
    public boolean registrarEmprestimo(Emprestimo emprestimo) {

        if (ferramentaDAO.isFerramentaEmprestada(emprestimo.getIdFerramenta().getId())) {
            throw new RuntimeException("Esta ferramenta já está emprestada. Não é possível realizar um novo empréstimo.");
        }

        if (amigoPendente(emprestimo.getIdAmigo().getId(), emprestimo.getId()) != 0) {
            throw new RuntimeException("O amigo já tem uma ferramenta emprestada e não devolveu.");
        }

        String sql = "INSERT INTO tb_emprestimos (id_amigo, id_ferramenta, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, emprestimo.getIdAmigo().getId());
            stmt.setInt(2, emprestimo.getIdFerramenta().getId());
            stmt.setDate(3, emprestimo.getDataEmprestimo());
            stmt.setDate(4, emprestimo.getDataDevolucao());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //deleta um emprestimo pelo seu id
    public boolean deleteEmprestimoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }
    
    //altera um emprestimo pelo seu objeto
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

    //retorna se o amigo tem uma ferramenta emprestada
    public int amigoPendente(int idAmigo, int idEmprestimo) {
        int idFerramenta = 0;

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet pdt = stmt.executeQuery("SELECT id_ferramenta FROM `tb_emprestimos` WHERE `id_amigo` = " + idAmigo + " AND `data_devolucao` IS NULL AND `id` != " + idEmprestimo);

            if (pdt.next()) {
                idFerramenta = pdt.getInt("id_ferramenta");
            }

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                this.getConexao().close();
            } catch (Exception e) {
            }
            try {
                this.getConexao().close();
            } catch (Exception e) {
            }
        }

        return idFerramenta;
    }

    //retorna os emprestimos cadastrados
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

    //metodo para se conectar ao banco de dados
    private Connection getConexao() {
        return Conexao.getConexao();
    }
}
