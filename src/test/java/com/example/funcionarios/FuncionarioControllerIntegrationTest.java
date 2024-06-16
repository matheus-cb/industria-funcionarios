package com.example.funcionarios;

import com.example.funcionarios.model.Funcionario;
import com.example.funcionarios.repository.FuncionarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FuncionarioControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private FuncionarioRepository funcionarioRepository;

  @BeforeEach
  public void setUp() {
    funcionarioRepository.deleteAll();
  }

  @Test
  public void listarTodos_ShouldReturnAllFuncionarios() throws Exception {
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

    funcionarioRepository.saveAll(List.of(func1, func2));

    mockMvc.perform(get("/funcionarios")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].nome").value("Maria"))
        .andExpect(jsonPath("$[1].nome").value("João"));
  }
}
