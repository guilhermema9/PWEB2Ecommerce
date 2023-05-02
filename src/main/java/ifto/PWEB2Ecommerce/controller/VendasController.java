package ifto.PWEB2Ecommerce.controller;

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
@SessionAttributes("vendas")
@RequestMapping("vendas")
public class VendasController {

    @Autowired
    VendaRepository repository;
    //@Autowired
    //Venda venda;
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("vendas", repository.vendas());
        return new ModelAndView("/vendas/list", model);
    }

    @GetMapping("/carrinho")
    public ModelAndView carrinho(ModelMap model) {
        model.addAttribute("vendas", repository.vendas());
        return new ModelAndView("/vendas/carrinho", model);
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