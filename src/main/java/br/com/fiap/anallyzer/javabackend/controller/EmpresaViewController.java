package br.com.fiap.anallyzer.javabackend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.anallyzer.javabackend.dto.EmpresaRequestDTO;
import br.com.fiap.anallyzer.javabackend.dto.EmpresaResponseDTO;
import br.com.fiap.anallyzer.javabackend.service.EmpresaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/empresas")
public class EmpresaViewController {

  private final EmpresaService empresaService;

  public EmpresaViewController(EmpresaService empresaService) {
    this.empresaService = empresaService;
  }

  @GetMapping
  public String listarTodasEmpresas(Model model) {
    List<EmpresaResponseDTO> empresas = empresaService.listarTodasEmpresas();
    model.addAttribute("empresas", empresas);
    return "empresas/lista";
  }

  @GetMapping("/{id}")
  public String listarEmpresaPorId(@PathVariable Long id, Model model) {
    EmpresaResponseDTO empresa = empresaService.listarEmpresaPorId(id);
    model.addAttribute("empresa", empresa);
    return "empresas/detalhes";
  }

  @GetMapping("/nova")
  public String mostrarFormularioEmpresa(Model model) {
    model.addAttribute("empresa", new EmpresaRequestDTO("", "", ""));
    return "empresas/formulario";
  }

  @PostMapping
  public String criarEmpresa(@Valid @ModelAttribute EmpresaRequestDTO empresaRequestDTO, Model model) {
    // Não é comum redirecionar para a mesma página após POST, mas pode ser
    // necessário dependendo do fluxo
    empresaService.criarEmpresa(empresaRequestDTO);
    return "redirect:/empresas";
  }
}
