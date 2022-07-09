package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {
    
    public Connection Conecta(){
        try {
            return DriverManager.getConnection("Jdbc:mysql://localhost:3306/lojainformaticabd","root","102030");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com bd"+ex);
        }
        return null;
    } 
     
    
    
}
