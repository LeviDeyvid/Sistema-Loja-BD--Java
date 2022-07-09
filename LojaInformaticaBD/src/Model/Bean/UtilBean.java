package Model.Bean;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UtilBean {
    
    public void LimpaCampos(JPanel container){
        Component components[] =  container.getComponents();
        for(Component component : components){
            if (component instanceof JTextField) {
                ((JTextField)component).setText(null);
            }
        }
    }
    
}

 