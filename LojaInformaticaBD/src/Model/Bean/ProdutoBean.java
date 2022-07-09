
package Model.Bean;

import Model.Bean.FornecedoresBean;

public class ProdutoBean {
    private int id;
    private String descricao;
    private double preco;
    private int qtd;
    private FornecedoresBean fornecedor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public FornecedoresBean getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedoresBean fornecedor) {
        this.fornecedor = fornecedor;
    }
}
