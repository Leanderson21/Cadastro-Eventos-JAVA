package com.api5.Repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.api5.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

	
}
