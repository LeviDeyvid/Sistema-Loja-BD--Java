
package Model.Dao;

import Model.Bean.FornecedoresBean;
import Model.Bean.ProdutoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDao {
    private Connection con;
    
    public ProdutoDao(){
        this.con = new ConexaoBD.Conexao().Conecta();
    }
    
    public void cadastrarProduto(ProdutoBean obj){
        try {
            String sql = "insert into produtos(descricao,preco,qtd_estoque,for_id)values(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro "+e);
        }
    }
    
    public void alterarProduto(ProdutoBean obj){
        try {
            
            String sql="update produtos set descricao=?,preco=?,qtd_estoque=?,for_id=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd());
            stmt.setInt(4, obj.getFornecedor().getId());
             stmt.setInt(5, obj.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso");
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro"+e);
        }       
    }
    
    public void excluirProduto(ProdutoBean obj){
        try {
            String sql ="delete from produtos where id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1,obj.getId());
        stmt.execute();
        stmt.close();
        JOptionPane.showMessageDialog(null, "Produto Excluido com Sucesso");
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Erro"+e);
        }
        
    }
    
    public List <ProdutoBean>ListarProdutos(){
        try {
            List<ProdutoBean> lista = new ArrayList<>();
    String sql = "select p.id,p.descricao,p.preco,p.qtd_estoque,f.nome  from produtos as p inner join fornecedores as f on(p.for_id=f.id)";
    PreparedStatement stmt = con.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
    while(rs.next()){
        FornecedoresBean f = new FornecedoresBean();
        ProdutoBean obj = new ProdutoBean();
        obj.setId(rs.getInt("p.id"));
        obj.setDescricao(rs.getString("p.descricao"));
        obj.setPreco(rs.getDouble("p.preco"));
        obj.setQtd(rs.getInt("p.qtd_estoque"));
        f.setNome(rs.getString("f.nome"));
        obj.setFornecedor(f);
        lista.add(obj);
    }
    return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<ProdutoBean> pesquisaNomeProduto(String nome){
        try {
            List<ProdutoBean> lista = new ArrayList<>();
            String sql = "select p.id,p.descricao,p.preco,p.qtd_estoque,f.nome from produtos as p inner join fornecedores as f on(p.for_id=f.id) where p.descricao like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ProdutoBean produto = new ProdutoBean();
                FornecedoresBean fornecedor = new FornecedoresBean();
                produto.setId(rs.getInt("p.id"));
                produto.setDescricao(rs.getString("p.descricao"));
                produto.setPreco(rs.getDouble("p.preco"));
                produto.setQtd(rs.getInt("p.qtd_estoque"));
                fornecedor.setNome(rs.getString("nome"));
                produto.setFornecedor(fornecedor);
                lista.add(produto);
                
            }
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public ProdutoBean pesquisaNomeP(String nome){
        try {
            
            String sql = "select p.id,p.descricao,p.preco,p.qtd_estoque,f.nome from produtos as p inner join fornecedores as f on(p.for_id=f.id) where p.descricao like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
              ProdutoBean produto = new ProdutoBean();
                FornecedoresBean fornecedor = new FornecedoresBean();

                  if(rs.next()){
                produto.setId(rs.getInt("p.id"));
                produto.setDescricao(rs.getString("p.descricao"));
                produto.setPreco(rs.getDouble("p.preco"));
                produto.setQtd(rs.getInt("p.qtd_estoque"));
                fornecedor.setNome(rs.getString("nome"));
                produto.setFornecedor(fornecedor);

                
            }
            return produto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void baixaDeEstoque(int id,int qtd_novo){
        try {
            String sql = "update produtos set qtd_estoque =? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, qtd_novo);
            stmt.setInt(2,id);
            stmt.execute();
            stmt.close();
             //  JOptionPane.showMessageDialog(null, "");
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Erro ao Insererir"+e);
        }
 
   }
    public void adicDeEstoque(int id,int qtd_novo){
        try {
            String sql = "update produtos set qtd_estoque =? where id =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,qtd_novo );
            stmt.setInt(2,id);
            stmt.execute();
            stmt.close();
               JOptionPane.showMessageDialog(null, "Produto Inserido com Sucesso no estoque");
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Erro ao Insererir"+e);
        }
 
   }
    
    public int retornaQuantidadeAtualizada(int id){
        try {
            int qtd_estoque = 0;
            String sql="select qtd_estoque from produtos where id =?";
               PreparedStatement  stmt = con.prepareStatement(sql);
               stmt.setInt(1, id);
               ResultSet rs = stmt.executeQuery();
               if (rs.next()) {
                qtd_estoque = (rs.getInt("qtd_estoque"));
            }
               return qtd_estoque;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
