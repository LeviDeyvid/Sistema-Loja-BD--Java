
package Model.Dao;

import Model.Bean.ItemBean;
import Model.Bean.ProdutoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ItemDao {
    private Connection con;

public ItemDao(){
    this.con = new ConexaoBD.Conexao().Conecta();
}
    
public void CadastrarItemVenda(ItemBean item){
    try {
        
        String sql = "insert into itemvendas (venda_id, produto_id, qtd, subtotal)values(?, ? , ? ,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, item.getVendas().getId());
        stmt.setInt(2, item.getProduto().getId());
        stmt.setInt(3, item.getQtd());
        stmt.setDouble(4, item.getSubTotal());
        stmt.execute();
        stmt.close();
    } catch (Exception e) {
       throw new RuntimeException(e);
    }
}

public List<ItemBean>listaItensVendas(int venda_id){
    try {
        
        List<ItemBean>lista = new ArrayList<>();
        
        String sql = "select p.descricao, i.qtd,p.preco, i.subtotal from itemvendas as i inner join tb_produtos on (i.produto_id=p.id)"
                + " where i.venda_id =?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, venda_id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            ItemBean item  = new ItemBean();
            ProdutoBean produto = new ProdutoBean();
            produto.setDescricao(rs.getString("p.descricao"));
            item.setQtd(rs.getInt("i.qtd"));
            produto.setPreco(rs.getDouble("p.preco"));
            item.setSubTotal(rs.getDouble("i.subtotal"));
            item.setProduto(produto);
            
            lista.add(item);
        }
        return lista;
    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "ERROOOOOOOOOOOO");
        
    }
    return null;
}

}
