package com.controle.caixa.controller;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {

    @Autowired
    LancamentoService lancamentoService;    

    @GetMapping("/listarTodosLancamentos")
    public ResponseEntity<List> getAllLancamentos() {
        List<LancamentoEntity> lancamentos = lancamentoService.listarTodosLancamentos();
        return new ResponseEntity<>(lancamentos, HttpStatus.OK);
    }
    
    @GetMapping("/pesquisarLancamento/{id}")
    public ResponseEntity<LancamentoEntity> getLancamentoById(@PathVariable Integer id) {
        LancamentoEntity lancamento = lancamentoService.getLancamentoId(id);
        return new ResponseEntity<>(lancamento, HttpStatus.OK);
    }
    
    @PostMapping("/adicionarLancamento")
    public ResponseEntity<LancamentoEntity> addLancamento(@RequestBody LancamentoEntity lancamento) {
        var novoLancamento = lancamentoService.criarLancamento(lancamento);
        return new ResponseEntity<>(novoLancamento, HttpStatus.CREATED);
    }
    
    @PutMapping("/atualizarLancamento/{id}")
    public ResponseEntity<LancamentoEntity> atualizarLancamento(@PathVariable Integer id, @RequestBody LancamentoEntity lancamento) {
        var lancamentoAtualizado = lancamentoService.atualizarLancamento(id, lancamento);
        return new LancamentoEntity<>(lancamentoAtualizado, HttpStatus.OK);
    }
    
    @PutMapping("/inativarLancamento/{id}")
    public ResponseEntity inativarLancamento(@PathVariable Integer id) {
        lancamentoService.inativarLancamento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }      
}