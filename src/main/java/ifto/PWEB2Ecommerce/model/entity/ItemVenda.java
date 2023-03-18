package ifto.PWEB2Ecommerce.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class ItemVenda implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @OneToOne
    private Produto produto;
    @ManyToOne
    private Venda venda;
    private double quantidade;

    public double total(){
        return quantidade* produto.getValor();
    }
}
