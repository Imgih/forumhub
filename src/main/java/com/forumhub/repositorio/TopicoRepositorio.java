package com.forumhub.repositorio;

import com.forumhub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepositorio extends JpaRepository<Topico, Long> {
    // Métodos de consulta customizados, se necessário
}
