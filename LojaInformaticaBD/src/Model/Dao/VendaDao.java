
package Model.Dao;

import Model.Bean.ClienteBean;
import Model.Bean.VendasBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VendaDao {
    private Connection con;
    
    public VendaDao(){
        this.con = new ConexaoBD.Conexao().Conecta();
    }
    
    public void cadastrarVENDAS(VendasBean vendas){
        try {
            
            String sql ="insert into vendas (cliente_id,data_venda,total_venda,observacoes)values(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,vendas.getCliente().getId());
            stmt.setString(2,vendas.getData_Venda());
            stmt.setDouble(3,vendas.getTotal_Venda());
            stmt.setString(4,vendas.getObservacoes());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso, venda registrada!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro"+e);
        }
        
    }
    
    
    public int retornarAultimaVenda(){
        try {
            int idUltimaVenda = 0;
            String sql ="select max(id) id from vendas";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                VendasBean v = new VendasBean();
                v.setId(rs.getInt("id"));
                idUltimaVenda = v.getId();
            }
            return idUltimaVenda;
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    
    }    
    
    public List<VendasBean>vendasRealizadas(LocalDate data_inicio,LocalDate data_final){
        try {
            List<VendasBean> lista = new ArrayList<> ();
            String sql ="select v.id, c.nome, date_format(v.data_venda,' %d/%m/%y') as data_formatada, v.total_venda, v.observacoes from vendas as v inner join clientes as c on(v.cliente_id=c.id)where v.data_venda BETWEEN ? and?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data_inicio.toString());
            stmt.setString(2, data_final.toString());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                VendasBean venda = new VendasBean();
                ClienteBean cliente = new ClienteBean();
                venda.setId(rs.getInt("v.id"));
                cliente.setNome(rs.getString("c.nome"));
                
                venda.setData_Venda(rs.getString("data_formatada"));
                venda.setTotal_Venda(rs.getDouble("v.total_venda"));
                venda.setObservacoes(rs.getString("v.observacoes"));
                venda.setCliente(cliente);
                lista.add(venda);
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
