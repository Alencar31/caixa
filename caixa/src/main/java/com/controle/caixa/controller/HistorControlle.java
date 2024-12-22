package com.controle.caixa.controller;

import com.controle.caixa.data.HistoricoEntity;
import com.controle.caixa.service.HistoricoService;
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
public class HistorControlle {
    
    @Autowired
    HistoricoService historicoService;
    
    @GetMapping("/listarTodosHistoricos")
    public String ListarHistoricos(Model model) {
        model.addAttribute("listarTodosHistoricos", historicoService.listarTodosHistoricos());
        return "listarTodosHistoricos";
    }
    
    @GetMapping("/inativarHistorico/{id}")
    public String inativarHistorico(@PathVariable(value = "id") Integer id) {
        historicoService.inativarHistorico(id);
        return "redirect:/";
    }
    
    @GetMapping("/criarHistoricoForm")
    public String criarHistoricoForm(Model model) {
        HistoricoEntity historico = new HistoricoEntity();
        model.addAttribute("historico", historico);
        return "incluirHistorico";
    }
    
    @PostMapping("/salvarHistorico")
    public String salvarHistorico(@Valid @ModelAttribute("historico") HistoricoEntity historico, BindingResult result) {
        if (result.hasErrors()) {
            return "incluirHistorico";
        }        
        if (historico.getId()==null) {
            historicoService.criarHistorico(historico);
        } else {
            historicoService.atualizarHistorico(historico.getId(), historico);
        }
        return "redirect:/";
    }
    
    @GetMapping("/atualizarHistoricoForm/{id}")
    public String atualizarHistoricoForm(@PathVariable(value = "id") Integer id, Model model) {
        HistoricoEntity historico = historicoService.getHistoricoId(id);
        model.addAttribute("historico", historico);
        return "atualizarHistorico";
    }
}