package ifto.PWEB2Ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Transactional
public class PessoaFisica extends Pessoa{

    @NotBlank
    private String cpf;

    public PessoaFisica(Long id, String nome, String email, String telefone, List<Venda> vendas, List<Endereco> enderecos,String cpf) {
        super();
        this.cpf = cpf;
    }

    public PessoaFisica() {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
