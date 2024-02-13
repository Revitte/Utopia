package br.com.oitavo.utopia.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.oitavo.utopia.models.Todo;
import br.com.oitavo.utopia.repositories.Todorepository;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("todo/form", Map.of("todo", new Todo()));
    }
    
    /*
    public SomeData getMethodName(@RequestParam String param) {
        return new SomeData();
    }
    
    
     
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
