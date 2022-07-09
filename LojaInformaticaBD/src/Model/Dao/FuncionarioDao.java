
package Model.Dao;


import Model.Bean.FuncionarioBean;
import View.LoginView;
import View.MenuView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDao {
    private Connection con;
    
    public FuncionarioDao(){
this.con= new ConexaoBD.Conexao().Conecta();
}
    
    public void cadastrarFuncionarios(FuncionarioBean obj){
        
        try {
            String sql = "INSERT INTO funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)" +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setString(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Funcionario Cadastrado com Sucesso! :)");
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"Erro ao Cadastrar)"+ex);
        }
    }
    
    public void alterarFuncionario(FuncionarioBean obj){
        try {
            
            String sql = "UPDATE funcionarios set nome = ?, rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,endereco=?,"
                    + "numero=?,complemento=?,bairro=?,cidade=?,estado=? where id = ?";
            
           PreparedStatement  stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setString(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            stmt.setInt(17, obj.getId());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionario Alterado com sucesso!");
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Houve um erro "+e);
        }
    }
    
    public void excluirFuncionario(FuncionarioBean obj){
        try {
            
            String sql = "DELETE from funcionarios where id=?";
         PreparedStatement  stmt = con.prepareStatement(sql);
         stmt.setInt(1, obj.getId());
         
         stmt.execute();
         stmt.close();
         JOptionPane.showMessageDialog(null, "Funcionario Excluido Com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro"+e);
        }
    }
    
    public List<FuncionarioBean> ListarOsFuncionarios(){
        try {
            
            List<FuncionarioBean> list = new ArrayList<>();
            
            String sql = "SELECT * FROM funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                FuncionarioBean lista = new FuncionarioBean();
                
                lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setRg(rs.getString("rg"));
                lista.setCpf(rs.getString("cpf"));
                lista.setEmail(rs.getString("email"));
                lista.setSenha(rs.getString("senha"));
                lista.setCargo(rs.getString("cargo"));
                lista.setNivel_acesso(rs.getString("nivel_acesso"));
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
    public FuncionarioBean pesquisaFuncionario(String nome){
        try {
            
            String sql ="select * from funcionarios where nome =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            FuncionarioBean lista = new FuncionarioBean();

        while(rs.next()){
         lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setRg(rs.getString("rg"));
                lista.setCpf(rs.getString("cpf"));
                lista.setEmail(rs.getString("email"));
                lista.setSenha(rs.getString("senha"));
                lista.setCargo(rs.getString("cargo"));
                lista.setNivel_acesso(rs.getString("nivel_acesso"));
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
    
    public List<FuncionarioBean> pesquisarNome(String nome){
        try {
            List<FuncionarioBean> lista = new ArrayList<>();
            String sql = "select * from funcionarios where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                FuncionarioBean funcionario = new FuncionarioBean();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                 funcionario.setRg(rs.getString("rg"));
                 funcionario.setCpf(rs.getString("cpf"));
                  funcionario.setEmail(rs.getString("email"));
                  funcionario.setSenha(rs.getString("senha"));
                  funcionario.setCargo(rs.getString("cargo"));
                  funcionario.setNivel_acesso(rs.getString("nivel_acesso"));
                   funcionario.setTelefone(rs.getString("telefone"));
                    funcionario.setCelular(rs.getString("celular"));
                     funcionario.setCep(rs.getString("cep"));
                     funcionario.setEndereco(rs.getString("endereco"));
                      funcionario.setNumero(rs.getString("numero"));
                       funcionario.setComplemento(rs.getString("complemento"));
                        funcionario.setBairro(rs.getString("bairro"));
                         funcionario.setCidade(rs.getString("cidade"));
                          funcionario.setEstado(rs.getString("Estado"));
                lista.add(funcionario);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"" +e);
        }
        return null;
    }
    
    public void efetuarLogin(String email,String senha){
        try {
            String sql = "select * from funcionarios where email=? and senha =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2,senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("nivel_acesso").equals("ADMIN")) {
                    
                    MenuView menu = new MenuView();
                   
                     menu.usuarioLogado = rs.getString("nome");
                      JOptionPane.showMessageDialog(null, "Bem vindo: " +menu.usuarioLogado);
                     menu.setVisible(true);
                     
                }else if (rs.getString("nivel_acesso").equals("Usuario")) {
                    
                     MenuView menu = new MenuView();                   
                     menu.usuarioLogado = rs.getString("nome");
                       JOptionPane.showMessageDialog(null, "Bem vindo: " +menu.usuarioLogado);
                     menu.setVisible(true);
                }             
                
            }
            
             else{
                    LoginView login = new LoginView();
                    JOptionPane.showMessageDialog(null, "Dados Incorretos");
                    login.setVisible(true);
                }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}

