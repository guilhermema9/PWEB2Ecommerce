package ifto.PWEB2Ecommerce.controller;

import ifto.PWEB2Ecommerce.model.*;
import ifto.PWEB2Ecommerce.repository.PessoaFisicaRepository;
import ifto.PWEB2Ecommerce.repository.PessoaJuridicaRepository;
import ifto.PWEB2Ecommerce.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class LoginController {

    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;
    @Autowired
    PessoaJuridicaRepository pessoaJuridicaRepository;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/autenticacao/login");
    }

    @GetMapping("/cadastrar-pessoafisica")
    public String criarPessoaFisica(Model model) {
        model.addAttribute("pessoa", new PessoaFisica());
        return "/autenticacao/cadastrar/form-pessoafisica";
    }

    @GetMapping("/cadastrar-pessoajuridica")
    public String criarPessoaJuridica(Model model) {
        model.addAttribute("pessoa", new PessoaJuridica());
        return "/autenticacao/cadastrar/form-pessoajuridica";
    }

    @PostMapping("/salvar-pessoa/fisica")
    public String salvarPessoaFisica(@ModelAttribute("pessoa") PessoaFisica pessoa) {
        return salvarPessoa(pessoa);
    }

    @PostMapping("/salvar-pessoa/juridica")
    public String salvarPessoaJuridica(@ModelAttribute("pessoa") PessoaJuridica pessoa) {
        return salvarPessoa(pessoa);
    }

    private String salvarPessoa(Pessoa pessoa) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Role role = roleRepository.role("ROLE_USER");
        Usuario usuario = pessoa.getUsuario();
        String senhaCodificada = encoder.encode(usuario.getPassword());

        usuario.setPassword(senhaCodificada);
        usuario.setPessoa(pessoa);
        usuario.getRoles().add(role);
        usuario.getPessoa().getEnderecos().add(pessoa.getEnderecos().get(0));
        Endereco endereco = new Endereco();
        endereco.setPessoa(pessoa);

        /*for (Endereco endereco : pessoa.getEnderecos())
            endereco.setPessoa(pessoa);*/

        if (pessoa instanceof PessoaFisica) {
            pessoaFisicaRepository.save((PessoaFisica) pessoa);
        } else if (pessoa instanceof PessoaJuridica) {
            pessoaJuridicaRepository.save((PessoaJuridica) pessoa);
        }

        return "redirect:/login";
    }
}