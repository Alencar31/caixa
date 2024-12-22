package com.controle.caixa.controller;

import com.controle.caixa.data.LancamentoEntity;
import com.controle.caixa.service.LancamentoService;
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
public interface LancamController {
    
    @Autowired
    LancamentoService lancamentoService;
    
    @GetMapping("/listarTodosLancamentos")
    public String ListarLancamentos(Model model) {
        model.addAttribute("listarTodosLancamentos", lancamentoService.listarTodosLancamentos());
        return "listarTodosLancamentos";
    }
    
    @GetMapping("/inativarLancamento/{id}")
    public String inativarLancamento(@PathVariable(value = "id") Integer id) {
        lancamentoService.inativarLancamento(id);
        return "redirect:/";
    }
    
    @GetMapping("/criarLancamentoForm")
    public String criarLancamentoForm(Model model) {
        LancamentoEntity lancamento = new LancamentoEntity();
        model.addAttribute("lancamento", lancamento);
        return "incluirLancamento";
    }
    
    @PostMapping("/salvarLancamento")
    public String salvarLancamento(@Valid @ModelAttribute("lancamento") LancamentoEntity lancamento, BindingResult result) {
        if (result.hasErrors()) {
            return "incluirLancamento";
        }        
        if (lancamento.getId()==null) {
            lancamentoService.criarLancamento(lancamento);
        } else {
            lancamentoService.atualizarLancamento(lancamento.getId(), lancamento);
        }
        return "redirect:/";
    }
    
    @GetMapping("/atualizarLancamentoForm/{id}")
    public String atualizarLancamentoForm(@PathVariable(value = "id") Integer id, Model model) {
        LancamentoEntity lancamento = lancamentoService.getLancamentoId(id);
        model.addAttribute("lancamento", lancamento);
        return "atualizarLancamento";
    }
}