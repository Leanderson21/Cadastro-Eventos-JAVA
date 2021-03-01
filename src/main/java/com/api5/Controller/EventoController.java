package com.api5.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.api5.Repository.ConvidadoRepository;
import com.api5.Repository.EventoRepository;
import com.api5.model.Convidado;
import com.api5.model.Evento;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository event;
	
	@Autowired
	private ConvidadoRepository convid;
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "eventos/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(Evento evento) {
		event.save(evento);
		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping("/eventos")
	public ModelAndView buscarEvento() {
		ModelAndView mv = new ModelAndView("index"); // faz a renderização da pagina do template
			Iterable<Evento> evento = event.findAll(); // faz a busca no banco e joga na lista de eventos
			mv.addObject("evento", evento); // pega o objeto daqui e joga dentro da pagina do template
				return mv;
	}
	
	@RequestMapping(value="/{codigo}", method =RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") Long codigo){
		Evento evento = event.findById(codigo).get();
		ModelAndView mv = new ModelAndView("eventos/detalhesEvento");
		mv.addObject("evento", evento);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method =RequestMethod.POST)
	public String detalhesEvento(@PathVariable("codigo") Long codigo, Convidado convidado){
		Evento evento = event.findById(codigo).get();
		convidado.setEvento(evento);
		convid.save(convidado);
		return "redirect:/{codigo}";
	}
	
}
