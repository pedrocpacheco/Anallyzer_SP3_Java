package br.com.fiap.anallyzer.javabackend.controller;

import br.com.fiap.anallyzer.javabackend.dto.ClienteRequestDTO;
import br.com.fiap.anallyzer.javabackend.dto.ClienteResponseDTO;
import br.com.fiap.anallyzer.javabackend.model.Escolaridade;
import br.com.fiap.anallyzer.javabackend.model.EstadoCivil;
import br.com.fiap.anallyzer.javabackend.model.Genero;
import br.com.fiap.anallyzer.javabackend.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteViewController {

  private final ClienteService clienteService;

  public ClienteViewController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @GetMapping
  public String listarTodosClientes(Model model) {
    List<ClienteResponseDTO> clientes = clienteService.listarTodosClientes();
    model.addAttribute("clientes", clientes);
    return "clientes/listar";
  }

  @GetMapping("/{id}")
  public String visualizarCliente(@PathVariable Long id, Model model) {
    ClienteResponseDTO cliente = clienteService.listarClientePorId(id);
    model.addAttribute("cliente", cliente);
    return "clientes/visualizar";
  }

  @GetMapping("/novo")
  public String novoCliente(Model model) {
    model.addAttribute("clienteRequestDTO", new ClienteRequestDTO("", "", "", null, null, null));
    model.addAttribute("escolaridades", Escolaridade.values());
    model.addAttribute("estadosCivis", EstadoCivil.values());
    model.addAttribute("generos", Genero.values());
    return "clientes/novo";
  }

  @PostMapping("/novo")
  public String criarCliente(@ModelAttribute ClienteRequestDTO clienteRequestDTO) {
    clienteService.criarCliente(clienteRequestDTO);
    return "redirect:/clientes";
  }

  @GetMapping("/editar/{id}")
  public String editarCliente(@PathVariable Long id, Model model) {
    ClienteResponseDTO cliente = clienteService.listarClientePorId(id);
    model.addAttribute("cliente", cliente);
    return "clientes/editar";
  }

  @PostMapping("/editar/{id}")
  public String atualizarCliente(@PathVariable Long id, @ModelAttribute ClienteRequestDTO clienteRequestDTO) {
    clienteService.atualizarCliente(id, clienteRequestDTO);
    return "redirect:/clientes";
  }

  @GetMapping("/deletar/{id}")
  public String deletarCliente(@PathVariable Long id) {
    clienteService.deletarCliente(id);
    return "redirect:/clientes";
  }
}