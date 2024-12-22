package com.controle.caixa.controller;

import com.controle.caixa.data.ContaEntity;
import com.controle.caixa.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContController {
    
    @Autowired
    ContaService contaService;
    
    @GetMapping("/listarTodasContas")
    public String ListarContas(Model model) {
        model.addAttribute("listarTodasContas", contaService.listarTodasContas());
        return "listarTodasContas";
    }
    
    @GetMapping("/inativarConta/{id}")
    public String inativarConta(@PathVariable(value = "id") Integer id) {
        contaService.inativarConta(id);
        return "redirect:/";
    }
    
    @GetMapping("/criarContaForm")
    public String criarContaForm(Model model) {
        ContaEntity conta = new ContaEntity();
        model.addAttribute("conta", conta);
        return "incluirConta";
    }
    
    @PostMapping("/salvarConta")
    public String salvarConta(@Valid @ModelAttribute("conta") ContaEntity conta, BindingResult result) {
        if (result.hasErrors()) {
            return "incluirConta";
        }        
        if (conta.getId()==null) {
            contaService.criarConta(conta);
        } else {
            contaService.atualizarConta(conta.getId(), conta);
        }
        return "redirect:/";
    }
    
    @GetMapping("/atualizarContaForm/{id}")
    public String atualizarContaForm(@PathVariable(value = "id") Integer id, Model model) {
        ContaEntity conta = contaService.getContaId(id);
        model.addAttribute("conta", conta);
        return "atualizarConta";
    }
}