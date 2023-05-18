package ifto.PWEB2Ecommerce.controller;

import ifto.PWEB2Ecommerce.model.PessoaJuridica;
import ifto.PWEB2Ecommerce.repository.PessoaJuridicaRepository;
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
@RequestMapping("pessoasjuridicas")
public class PessoaJuridicaController {
    @Autowired
    PessoaJuridicaRepository repository;

    @GetMapping("/form")
    public String form (PessoaJuridica pessoaJuridica){
        return "pessoasjuridicas/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoasjuridicas", repository.pessoasJuridicas());
        return new ModelAndView("/pessoasjuridicas/list", model);
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid PessoaJuridica pessoaJuridica, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("pessoasjuridicas/form");
        }
        repository.save(pessoaJuridica);
        return new ModelAndView("redirect:/pessoasjuridicas/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/pessoasjuridicas/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("pessoaJuridica", repository.pessoaJuridica(id));
        return new ModelAndView("/pessoasjuridicas/form", model);
    }

    public ModelAndView update(PessoaJuridica pessoaJuridica){
        repository.update(pessoaJuridica);
        return new ModelAndView("redirect:/pessoasjuridicas/list");
    }
}