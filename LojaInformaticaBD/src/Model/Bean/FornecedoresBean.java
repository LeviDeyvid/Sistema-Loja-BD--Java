
package Model.Bean;

import Model.Bean.ClienteBean;


public class FornecedoresBean extends ClienteBean{
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString(){
     return this.getNome();
    }
}
