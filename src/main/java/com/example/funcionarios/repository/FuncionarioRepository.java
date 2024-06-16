package com.example.funcionarios.repository;

import com.example.funcionarios.model.Funcionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

  @Query("SELECT f FROM Funcionario f WHERE MONTH(f.dataNascimento) = :month")
  List<Funcionario> findByDataNascimentoMonth(@Param("month") int month);
}
