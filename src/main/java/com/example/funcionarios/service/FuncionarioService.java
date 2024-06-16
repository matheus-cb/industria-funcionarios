package com.example.funcionarios.service;

import com.example.funcionarios.model.Funcionario;
import com.example.funcionarios.repository.FuncionarioRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

  @Autowired
  private FuncionarioRepository funcionarioRepository;

  public List<Funcionario> listarTodos() {
    return funcionarioRepository.findAll();
  }

  public Funcionario salvar(Funcionario funcionario) {
    return funcionarioRepository.save(funcionario);
  }

  public void remover(Long id) {
    funcionarioRepository.deleteById(id);
  }

  public void atualizarSalarios() {
    List<Funcionario> funcionarios = funcionarioRepository.findAll();
    for (Funcionario funcionario : funcionarios) {
      BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.1")).setScale(2, RoundingMode.HALF_UP);
      funcionario.setSalario(novoSalario);
    }
    funcionarioRepository.saveAll(funcionarios);
  }

  public Map<String, List<Funcionario>> agruparPorFuncao() {
    return listarTodos().stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
  }

  public List<Funcionario> listarPorMesAniversario(int mes) {
    return funcionarioRepository.findByDataNascimentoMonth(mes);
  }

  public Funcionario buscarMaisVelho() {
    return listarTodos().stream().min(
            Comparator.comparing(Funcionario::getDataNascimento)
    ).orElse(null);
  }

  public List<Funcionario> ordenarPorNome() {
    return listarTodos().stream().sorted(
            Comparator.comparing(Funcionario::getNome)
    ).collect(Collectors.toList());
  }

  public BigDecimal somarSalarios() {
    return listarTodos().stream().map(Funcionario::getSalario)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public Map<String, BigDecimal> calcularSalariosMinimos(BigDecimal salarioMinimo) {
    return listarTodos().stream().collect(
            Collectors.toMap(Funcionario::getNome,
            f -> f.getSalario().divide(salarioMinimo, RoundingMode.HALF_DOWN)));
  }
}
