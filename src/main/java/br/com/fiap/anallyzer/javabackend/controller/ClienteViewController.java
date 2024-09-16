package br.com.fiap.anallyzer.javabackend.controller;

import br.com.fiap.anallyzer.javabackend.dto.ClienteRequestDTO;
import br.com.fiap.anallyzer.javabackend.dto.ClienteResponseDTO;
import br.com.fiap.anallyzer.javabackend.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view/clientes")
public class ClienteViewController {

  private final ClienteService clienteService;

  public ClienteViewController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @GetMapping
  public String listarTodosClientes(Model model) {
    List<ClienteResponseDTO> clientes = clienteService.listarTodosClientes();
    model.addAttribute("clientes", clientes);
    return "clientes/lista";
  }

  @GetMapping("/{id}")
  public String listarClientePorId(@PathVariable Long id, Model model) {
    ClienteResponseDTO cliente = clienteService.listarClientePorId(id);
    model.addAttribute("cliente", cliente);
    return "clientes/detalhes";
  }

  @GetMapping("/novo")
  public String mostrarFormularioCliente(Model model) {
    model.addAttribute("cliente", new ClienteRequestDTO("", "", "", null, null, null));
    return "clientes/formulario";
  }

  @PostMapping
  public String criarCliente(@ModelAttribute ClienteRequestDTO clienteRequestDTO) {
    clienteService.criarCliente(clienteRequestDTO);
    return "redirect:/view/clientes";
  }
}
