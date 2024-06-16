package com.example.funcionarios.controller;

import com.example.funcionarios.model.Funcionario;
import com.example.funcionarios.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
@Tag(name = "Funcionarios", description = "Gerenciamento de funcionários")
public class FuncionarioController {

  @Autowired
  private FuncionarioService funcionarioService;

  @Operation(summary = "Listar todos os funcionários")
  @GetMapping
  public List<Funcionario> listarTodos() {
    return funcionarioService.listarTodos();
  }

  @Operation(summary = "Salvar um novo funcionário")
  @PostMapping
  public Funcionario salvar(@RequestBody Funcionario funcionario) {
    return funcionarioService.salvar(funcionario);
  }

  @Operation(summary = "Remover um funcionário pelo ID")
  @DeleteMapping("/{id}")
  public void remover(@PathVariable Long id) {
    funcionarioService.remover(id);
  }

  @Operation(summary = "Atualizar salários de todos os funcionários em 10%")
  @PutMapping("/atualizar-salarios")
  public void atualizarSalarios() {
    funcionarioService.atualizarSalarios();
  }

  @Operation(summary = "Agrupar funcionários por função")
  @GetMapping("/agrupar-por-funcao")
  public Map<String, List<Funcionario>> agruparPorFuncao() {
    return funcionarioService.agruparPorFuncao();
  }

  @Operation(summary = "Listar funcionários por mês de aniversário")
  @GetMapping("/aniversarios/{mes}")
  public List<Funcionario> listarPorMesAniversario(@PathVariable int mes) {
    return funcionarioService.listarPorMesAniversario(mes);
  }

  @Operation(summary = "Buscar o funcionário mais velho")
  @GetMapping("/mais-velho")
  public Funcionario buscarMaisVelho() {
    return funcionarioService.buscarMaisVelho();
  }

  @Operation(summary = "Ordenar funcionários por nome")
  @GetMapping("/ordenar-por-nome")
  public List<Funcionario> ordenarPorNome() {
    return funcionarioService.ordenarPorNome();
  }

  @Operation(summary = "Somar salários de todos os funcionários")
  @GetMapping("/somar-salarios")
  public BigDecimal somarSalarios() {
    return funcionarioService.somarSalarios();
  }

  @Operation(summary = "Calcular quantidade de salários mínimos por função")
  @GetMapping("/salarios-minimos")
  public Map<String, BigDecimal> calcularSalariosMinimos() {
    return funcionarioService.calcularSalariosMinimos(new BigDecimal("1212.00"));
  }
}
