package ifto.PWEB2Ecommerce.controller;

import ifto.PWEB2Ecommerce.model.PessoaFisica;
import ifto.PWEB2Ecommerce.repository.PessoaFisicaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("pessoasfisicas")
public class PessoaFisicaController {
    @Autowired
    PessoaFisicaRepository repository;

    @GetMapping("/form")
    public String form (PessoaFisica pessoaFisica){
        return "pessoasfisicas/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoasfisicas", repository.pessoasFisicas());
        return new ModelAndView("/pessoasfisicas/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid PessoaFisica pessoaFisica, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("pessoasfisicas/form");
        }
        repository.save(pessoaFisica);
        return new ModelAndView("redirect:/pessoasfisicas/list");
    }

    @GetMapping("/remode/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/pessoasfisicas/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("pessoaFisica", repository.pessoaFisica(id));
        return new ModelAndView("/pessoasfisicas/form", model);
    }

    public ModelAndView update(PessoaFisica pessoaFisica){
        repository.update(pessoaFisica);
        return new ModelAndView("redirect:/pessoasfisicas/list");
    }
}
