/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author lucas
 */
public class Emprestimo {

    private int id;
    private Amigo idAmigo;
    private Ferramenta idFerramenta;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(int id, Amigo idAmigo, Ferramenta idFerramenta, Date dataEmprestimo, Date dataDevolucao) {
        this.id = id;
        this.idAmigo = idAmigo;
        this.idFerramenta = idFerramenta;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Amigo getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Amigo idAmigo) {
        this.idAmigo = idAmigo;
    }

    public Ferramenta getIdFerramenta() {
        return idFerramenta;
    }

    public void setIdFerramenta(Ferramenta idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

}
