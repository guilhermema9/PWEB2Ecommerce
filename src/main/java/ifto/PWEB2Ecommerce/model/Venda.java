package ifto.PWEB2Ecommerce.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda implements Serializable   {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private LocalDate data;
    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itens;
    @ManyToOne
    private Pessoa cliente;

    public Venda() {
        itens = new ArrayList<>();
        data = LocalDate.now();
    }

    public double total(){
        double total=0;
        for (ItemVenda item : itens ){
            total = total + item.total();
        }
        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }
}
