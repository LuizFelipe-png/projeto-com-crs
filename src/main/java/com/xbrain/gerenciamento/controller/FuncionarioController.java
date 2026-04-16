/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xbrain.gerenciamento.controller;

import com.xbrain.gerenciamento.model.FuncionarioBean;
import com.xbrain.gerenciamento.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Aluno
 */
@Controller
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService
            funcionarioService;
    
    @GetMapping("/funcionarios")
    public String getFuncionarios(Model model) {
        List<FuncionarioBean> lista = funcionarioService.lerTodos();
        model.addAttribute("lista", lista);
        return "funcionarios";
    }
    @GetMapping("/perfil")
    public String abrirEdicao(@RequestParam int id, Model model){
        FuncionarioBean f = funcionarioService.lerPorId(id);
        model.addAttribute("funcionario", f);
        return "perfil";
    }
    @PostMapping("/salvar")
    public String salvarDados(@ModelAttribute FuncionarioBean funcionario){
        funcionarioService.editarFuncionario(funcionario);
        return "redirect:/funcionarios";
    }
    

    
}

