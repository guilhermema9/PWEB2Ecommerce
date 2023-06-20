package ifto.PWEB2Ecommerce.controller;

import ifto.PWEB2Ecommerce.model.*;
import ifto.PWEB2Ecommerce.repository.*;
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
    @Autowired
    PessoaFisicaRepository pessoaFisicaRepository;
    @Autowired
    PessoaJuridicaRepository pessoaJuridicaRepository;
    @Autowired
    ItemVendaRepository itemVendaRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("vendas", repository.vendas());
        return new ModelAndView("/vendas/list", model);
    }

    @PostMapping("/carrinho")
    public ModelAndView carrinho(ItemVenda itemVenda) {
        Produto produto = produtoRepository.produto(itemVenda.getProduto().getId());
        boolean valor = true;
        for (int i=0; i<venda.getItens().size(); i++){
            if (venda.getItens().get(i).getProduto().getId() == produto.getId()){
                venda.getItens().get(i).setQuantidade(venda.getItens().get(i).getQuantidade()+itemVenda.getQuantidade());
                valor = false;
            }
        }
        if(valor){
            itemVenda.setProduto(produto);
            venda.getItens().add(itemVenda);
            itemVenda.setVenda(venda);
        }
        if(venda.getItens().size() == 0){
            itemVenda.setProduto(produto);
            venda.getItens().add(itemVenda);
            itemVenda.setVenda(venda);
        }
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/carrinho")
    public String carrinhoList(ModelMap model){
        model.addAttribute("pessoaFisica", new PessoaFisica());
        return "/vendas/carrinho";
    }

    @PostMapping("/selecionapessoafisica")
    public String selecionaPessoaFisica(PessoaFisica pessoaFisica){
        venda.setCliente(pessoaFisicaRepository.pessoaFisica(pessoaFisica.getId()));
        pessoaFisica.getVendas().add(venda);
        return "/vendas/selecionaendereco";
    }

    @PostMapping("/selecionapessoajuridica")
    public String selecionaPessoaJuridica(PessoaJuridica pessoaJuridica){
        venda.setCliente(pessoaJuridicaRepository.pessoaJuridica(pessoaJuridica.getId()));
        pessoaJuridica.getVendas().add(venda);
        return "/vendas/selecionaendereco";
    }

    @GetMapping("carregar-pessoa")
    public String carregar(@RequestParam String tipo, ModelMap model){
        if(tipo.equals("Pessoa Física")){
            //return lista(pessoas) de pf
            model.addAttribute("pessoas", pessoaFisicaRepository.pessoasFisicas());
        }else{
            //return lista(pessoas) de pj
            model.addAttribute("pessoas", pessoaJuridicaRepository.pessoasJuridicas());
        }
        return "/vendas/carrinho";
    }

    @GetMapping("seleciona-endereco/{id}")
    public ModelAndView selecionaEndereco(@PathVariable("id") Long id){
        Pessoa pessoa = null;
        if ( pessoaFisicaRepository.pessoaFisica(id) instanceof PessoaFisica ){
            pessoa = pessoaFisicaRepository.pessoaFisica(id);
        } else {
            pessoa = pessoaJuridicaRepository.pessoaJuridica(id);
        }
        venda.setCliente(pessoa);
        return new ModelAndView("/vendas/selecionaendereco");
    }

    @GetMapping("/save/{id}")
    public ModelAndView save(@PathVariable("id") Long id){
        Endereco enderecoDeEntrega = enderecoRepository.endereco(id);
        venda.setEndereco(enderecoDeEntrega);
        repository.save(venda);
        venda.getItens().clear();
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/removeItemVenda/{id}")
    public ModelAndView removeItemVenda(@PathVariable("id") int id){
        venda.getItens().remove(id);
        return new ModelAndView("redirect:/vendas/carrinho");
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

    @GetMapping("/detalhes/{id}")
    public ModelAndView detalhes(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("venda",repository.venda(id));
        return new ModelAndView("/vendas/detalhes",model);
    }
}