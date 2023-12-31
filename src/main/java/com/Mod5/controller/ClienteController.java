package com.Mod5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Mod5.entities.Cliente;
import com.Mod5.repositories.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	private final ClienteRepository ClienteRepository;

    ClienteController(ClienteRepository ClienteRepository) {
        this.ClienteRepository = ClienteRepository;
    }

	@GetMapping
	public ModelAndView cliente() {
		ModelAndView modelAndView = new ModelAndView("views/cliente/index.html");
		modelAndView.addObject("cliente", ClienteRepository.findAll());

		modelAndView.addObject("cliente", new Cliente());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		ClienteRepository.save(cliente);

		return "redirect:/clinte";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		ClienteRepository.deleteById(id);

		return "redirect:/cliente";
	}

}
	

