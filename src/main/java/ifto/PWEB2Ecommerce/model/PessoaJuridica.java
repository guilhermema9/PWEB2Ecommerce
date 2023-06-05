package ifto.PWEB2Ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class PessoaJuridica extends Pessoa{

    @NotBlank
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Long id, String nome, String email, String telefone, List<Venda> vendas, List<Endereco> enderecos, String cnpj) {
        super();
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
