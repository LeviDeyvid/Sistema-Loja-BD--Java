package Model.Dao;

import Model.Bean.FornecedoresBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedoresDao {
    private Connection con;
    
   public  FornecedoresDao(){
    this.con= new ConexaoBD.Conexao().Conecta();
    }
    
     public void cadastrarFornecedor(FornecedoresBean obj){
        
        try {
            String sql = "INSERT INTO fornecedores (nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)" +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setString(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Forncedor Cadastrado com Sucesso! :)");
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"Erro ao Cadastrar)"+ex);
        }
    }
    
    
    public void alterarFornecedor(FornecedoresBean obj){
        try {
            
            String sql = "UPDATE fornecedores set nome = ?,cnpj=?,email=?,telefone=?,celular=?,cep=?,endereco=?,"
                    + "numero=?,complemento=?,bairro=?,cidade=?,estado=? where id = ?";
            
           PreparedStatement  stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setString(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());
            stmt.setInt(13, obj.getId());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Houve um erro "+e);
        }
    }
    
    public void excluirFornecedor(FornecedoresBean obj){
        try {
            
            String sql = "DELETE from fornecedores where id=?";
         PreparedStatement  stmt = con.prepareStatement(sql);
         stmt.setInt(1, obj.getId());
         
         stmt.execute();
         stmt.close();
         JOptionPane.showMessageDialog(null, "Excluido Com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro"+e);
        }
    }

    public List<FornecedoresBean> ListarOsFornecedores(){
        try {
            
            List<FornecedoresBean> list = new ArrayList<>();
            
            String sql = "SELECT * FROM fornecedores";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                FornecedoresBean lista = new FornecedoresBean();
                
                lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setCnpj(rs.getString("cnpj"));
                lista.setEmail(rs.getString("email"));
                lista.setTelefone(rs.getString("telefone"));
                lista.setCelular(rs.getString("celular"));
                lista.setCep(rs.getString("cep"));
                lista.setEndereco(rs.getString("endereco"));
                lista.setNumero(rs.getString("numero"));
                lista.setComplemento(rs.getString("complemento"));
                lista.setBairro(rs.getString("bairro"));
                lista.setCidade(rs.getString("cidade"));
                lista.setEstado(rs.getString("estado"));
                
                list.add(lista);
            }
            return list;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro"+ex);       
        }
        return null;
    }
    
  @SuppressWarnings("empty-statement")
    public FornecedoresBean pesquisaFornecedores(String nome){
        try {
            
            String sql ="select * from fornecedores where nome =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            FornecedoresBean lista = new FornecedoresBean();

        while(rs.next()){
         lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setCnpj(rs.getString("cnpj"));
                lista.setEmail(rs.getString("email"));
                lista.setTelefone(rs.getString("telefone"));
                lista.setCelular(rs.getString("celular"));
                lista.setCep(rs.getString("cep"));
                lista.setEndereco(rs.getString("endereco"));
                lista.setNumero(rs.getString("numero"));
                lista.setComplemento(rs.getString("complemento"));
                lista.setBairro(rs.getString("bairro"));
                lista.setCidade(rs.getString("cidade"));
                lista.setEstado(rs.getString("estado"));   
        }
        return lista;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro "+e);
        }
        return null;
    }
    
    public List<FornecedoresBean> pesquisarNome(String nome){
        try {
            List<FornecedoresBean> lista = new ArrayList<>();
            String sql = "select * from fornecedores where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                FornecedoresBean cliente = new FornecedoresBean();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                 cliente.setCnpj(rs.getString("cnpj"));
                  cliente.setEmail(rs.getString("email"));
                   cliente.setTelefone(rs.getString("telefone"));
                    cliente.setCelular(rs.getString("celular"));
                     cliente.setCep(rs.getString("cep"));
                     cliente.setEndereco(rs.getString("endereco"));
                      cliente.setNumero(rs.getString("numero"));
                       cliente.setComplemento(rs.getString("complemento"));
                        cliente.setBairro(rs.getString("bairro"));
                         cliente.setCidade(rs.getString("cidade"));
                          cliente.setEstado(rs.getString("Estado"));
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"" +e);
        }
        return null;
    }
    
}
