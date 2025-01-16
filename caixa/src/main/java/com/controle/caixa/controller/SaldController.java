package com.controle.caixa.controller;

import com.controle.caixa.data.SaldoEntity;
import com.controle.caixa.service.SaldoService;
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
public class SaldController {
    
    @Autowired
    SaldoService saldoService;
    
    @GetMapping("/listarTodosSaldos")
    public String ListarSaldos(Model model) {
        model.addAttribute("listarTodosSaldos", saldoService.listarTodosSaldos());
        return "listarTodosSaldos";
    }
    
    @PostMapping("/salvarSaldo")
    public String salvarSaldo(@Valid @ModelAttribute("lancamento") SaldoEntity saldo, BindingResult result) {
        if (result.hasErrors()) {
            return "incluirSaldo";
        }        
        if (saldo.getId()==null) {
            saldoService.criarSaldo(saldo);
        } else {
            saldoService.atualizarSaldo(saldo.getId(), saldo);
        }
        return "redirect:/";
    }
}
