package com.api5.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.api5.Repository.EventoRepository;
import com.api5.model.Evento;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository event;
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "eventos/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(Evento evento) {
		event.save(evento);
		
		return "redirect:/cadastrarEvento";
	}
	
	
	
}
