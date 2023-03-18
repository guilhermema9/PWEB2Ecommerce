package ifto.PWEB2Ecommerce.controller;

import ifto.PWEB2Ecommerce.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("vendas")
public class VendasController {
    @Autowired
    VendaRepository repository;

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("vendas", repository.vendas());
        return new ModelAndView("/vendas/list", model);
    }
}