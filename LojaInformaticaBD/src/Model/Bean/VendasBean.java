package Model.Bean;

public class VendasBean {
    private int id;
    private ClienteBean cliente;
    private String data_Venda;
    private double total_Venda;
    private String observacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteBean getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBean cliente) {
        this.cliente = cliente;
    }

    public String getData_Venda() {
        return data_Venda;
    }

    public void setData_Venda(String data_Venda) {
        this.data_Venda = data_Venda;
    }

    public double getTotal_Venda() {
        return total_Venda;
    }

    public void setTotal_Venda(double total_Venda) {
        this.total_Venda = total_Venda;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

 
}
