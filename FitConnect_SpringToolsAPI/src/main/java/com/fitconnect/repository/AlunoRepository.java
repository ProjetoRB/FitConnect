package com.fitconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fitconnect.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
}