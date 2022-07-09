package Model.Dao;

import ConexaoBD.Conexao;
import Model.Bean.ClienteBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDao {
  private Connection con;
    
    public ClienteDao(){
       this.con = new Conexao().Conecta();
    }
    
    public void cadastrarClientes(ClienteBean obj){
        
        try {
            String sql = "INSERT INTO clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)" +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setString(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Cliente Cadastrado com Sucesso! :)");
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"Erro ao Cadastrar)"+ex);
        }
    }
    
    
    public void alterarCliente(ClienteBean obj){
        try {
            
            String sql = "UPDATE clientes set nome = ?, rg=?,cpf=?,email=?,telefone=?,celular=?,cep=?,endereco=?,"
                    + "numero=?,complemento=?,bairro=?,cidade=?,estado=? where id = ?";
            
           PreparedStatement  stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setString(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            stmt.setInt(14, obj.getId());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Houve um erro "+e);
        }
    }
    
    public void excluirCliente(ClienteBean obj){
        try {
            
            String sql = "DELETE from clientes where id=?";
         PreparedStatement  stmt = con.prepareStatement(sql);
         stmt.setInt(1, obj.getId());
         
         stmt.execute();
         stmt.close();
         JOptionPane.showMessageDialog(null, "Excluido Com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro"+e);
        }
    }

    public List<ClienteBean> ListarOsClientes(){
        try {
            
            List<ClienteBean> list = new ArrayList<>();
            
            String sql = "SELECT * FROM clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ClienteBean lista = new ClienteBean();
                
                lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setRg(rs.getString("rg"));
                lista.setCpf(rs.getString("cpf"));
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
    public ClienteBean pesquisaCliente(String nome){
        try {
            
            String sql ="select * from clientes where nome =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            ClienteBean lista = new ClienteBean();

        while(rs.next()){
         lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setRg(rs.getString("rg"));
                lista.setCpf(rs.getString("cpf"));
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
    
    public List<ClienteBean> pesquisarNome(String nome){
        try {
            List<ClienteBean> lista = new ArrayList<>();
            String sql = "select * from clientes where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ClienteBean cliente = new ClienteBean();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                 cliente.setRg(rs.getString("rg"));
                 cliente.setCpf(rs.getString("cpf"));
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
    
     public ClienteBean pesquisaClienteCPF(String cpf){
        try {
            
            String sql ="select * from clientes where cpf =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            ClienteBean lista = new ClienteBean();

        while(rs.next()){
         lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setRg(rs.getString("rg"));
                lista.setCpf(rs.getString("cpf"));
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
}