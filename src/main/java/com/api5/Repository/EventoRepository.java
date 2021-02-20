package com.api5.Repository;

import org.springframework.data.repository.CrudRepository;

import com.api5.model.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {

}
