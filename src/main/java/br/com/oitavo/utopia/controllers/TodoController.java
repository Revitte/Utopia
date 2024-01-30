package br.com.oitavo.utopia.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.oitavo.utopia.repositories.Todorepository;

@Controller
public class TodoController {

    private final Todorepository todoRepository;

    public TodoController(Todorepository todorepository){
        this.todoRepository = todorepository;
    }

    @GetMapping("/")
    public ModelAndView list() {
        // var modelAndView = new ModelAndView("todo/list");
        // modelAndView.addObject("todos", todoRepository.findAll())
        // return modelAndView;
        return new ModelAndView(
            "todo/list", 
            Map.of("todos", todoRepository.findAll())
        );
    }
    
    /* 
    COMMIT: Injeção de dependencias no Spring
    @GetMapping("/")
    public ModelAndView home(){
        var modelAndView = new ModelAndView("home");
        modelAndView.addObject("nome", "Otávio Revitte");

        var alunos = List.of("Cleyson Lima", "Wesley Gado", "Elen Fonseca", "Beatriz Ana");
        modelAndView.addObject("alunos", alunos);

        modelAndView.addObject("ehProgramador", false);

        var todos = todoRepository.findAll();
        System.out.println(todos);

        return modelAndView;
    }
    */
    
}
