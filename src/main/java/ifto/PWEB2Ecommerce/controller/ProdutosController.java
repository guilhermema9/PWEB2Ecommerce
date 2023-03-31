package ifto.PWEB2Ecommerce.controller;

import ifto.PWEB2Ecommerce.model.Produto;
import ifto.PWEB2Ecommerce.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutosController {
    @Autowired
    ProdutoRepository repository;

    @GetMapping("/form")
    public String form (Produto produto){
        return "/produtos/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("produtos", repository.produtos());
        return new ModelAndView("/produtos/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Produto produto){
        repository.save(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", repository.produto(id));
        return new ModelAndView("/produtos/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        repository.update(produto);
        return new ModelAndView("redirect:/produtos/list");
    }
}