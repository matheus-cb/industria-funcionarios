package com.example.funcionarios;

import com.example.funcionarios.model.Funcionario;
import com.example.funcionarios.repository.FuncionarioRepository;
import com.example.funcionarios.service.FuncionarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FuncionarioServiceTest {

  @Mock
  private FuncionarioRepository funcionarioRepository;

  @InjectMocks
  private FuncionarioService funcionarioService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void listarTodos_ShouldReturnAllFuncionarios() {
    Funcionario func1 = new Funcionario();
    func1.setNome("Maria");
    func1.setDataNascimento(LocalDate.of(2000, 10, 18));
    func1.setSalario(new BigDecimal("2009.44"));
    func1.setFuncao("Operador");

    Funcionario func2 = new Funcionario();
    func2.setNome("João");
    func2.setDataNascimento(LocalDate.of(1990, 5, 12));
    func2.setSalario(new BigDecimal("2284.38"));
    func2.setFuncao("Operador");

    List<Funcionario> funcionarios = Arrays.asList(func1, func2);
    when(funcionarioRepository.findAll()).thenReturn(funcionarios);

    List<Funcionario> result = funcionarioService.listarTodos();

    assertEquals(2, result.size());
    assertEquals("Maria", result.get(0).getNome());
    assertEquals("João", result.get(1).getNome());
  }

  @Test
  public void atualizarSalarios_ShouldIncreaseSalarioByTenPercent() {
    Funcionario func1 = new Funcionario();
    func1.setNome("Maria");
    func1.setDataNascimento(LocalDate.of(2000, 10, 18));
    func1.setSalario(new BigDecimal("2009.44"));
    func1.setFuncao("Operador");

    List<Funcionario> funcionarios = Arrays.asList(func1);
    when(funcionarioRepository.findAll()).thenReturn(funcionarios);

    funcionarioService.atualizarSalarios();

    BigDecimal expectedSalario = new BigDecimal("2009.44").multiply(new BigDecimal("1.1")).setScale(2, RoundingMode.HALF_UP);
    func1.setSalario(func1.getSalario().setScale(2, RoundingMode.HALF_UP));
    assertEquals(expectedSalario, func1.getSalario());
  }
}
