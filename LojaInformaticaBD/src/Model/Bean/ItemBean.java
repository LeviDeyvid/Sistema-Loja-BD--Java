package Model.Bean;

public class ItemBean {
    private int id;
    private VendasBean vendas;
    private ProdutoBean produto;
    private int qtd;
    private double subTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VendasBean getVendas() {
        return vendas;
    }

    public void setVendas(VendasBean vendas) {
        this.vendas = vendas;
    }

    public ProdutoBean getProduto() {
        return produto;
    }

    public void setProduto(ProdutoBean produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
