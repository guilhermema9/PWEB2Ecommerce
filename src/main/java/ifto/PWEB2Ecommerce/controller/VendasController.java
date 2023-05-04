package ifto.PWEB2Ecommerce.controller;

import ifto.PWEB2Ecommerce.model.ItemVenda;
import ifto.PWEB2Ecommerce.model.Produto;
import ifto.PWEB2Ecommerce.model.Venda;
import ifto.PWEB2Ecommerce.repository.ProdutoRepository;
import ifto.PWEB2Ecommerce.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Scope("request")
@Transactional
@Controller
@RequestMapping("vendas")
public class VendasController {

    @Autowired
    VendaRepository repository;
    @Autowired
    Venda venda;
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("vendas", repository.vendas());
        return new ModelAndView("/vendas/list", model);
    }

    @PostMapping("/carrinho")
    public ModelAndView carrinho(ItemVenda itemVenda) {

        Produto p = produtoRepository.produto(itemVenda.getProduto().getId());

        boolean valor = true;
        for (int i=0; i<venda.getItens().size(); i++){
            if (venda.getItens().get(i).getProduto().getId() == p.getId()){
                venda.getItens().get(i).setQuantidade(venda.getItens().get(i).getQuantidade()+itemVenda.getQuantidade());
                valor = false;
            }
        }
        if(valor){
            itemVenda.setProduto(p);
            venda.getItens().add(itemVenda);
        }
        if(venda.getItens().size() == 0){
            itemVenda.setProduto(p);
            venda.getItens().add(itemVenda);}

        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/carrinho")
    public String carrinhoList(){
        return "/vendas/carrinho";
    }

    @PostMapping("/save")
    public ModelAndView save(Venda venda){
        repository.save(venda);
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("venda", repository.venda(id));
        return new ModelAndView("/vendas/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Venda venda) {
        repository.update(venda);
        return new ModelAndView("redirect:/vendas/list");
    }
}