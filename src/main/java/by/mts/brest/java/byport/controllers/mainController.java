package by.mts.brest.java.byport.controllers;

import by.mts.brest.java.byport.EmplRepository;
import by.mts.brest.java.byport.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {
    @Autowired
    private EmplRepository emplRepository;
    @GetMapping("/")
    public String pagehomeEmpl (Model model){
        model.addAttribute("title", "Get List in DataBase");
        Iterable<Employee> employees = emplRepository.findAll();
        model.addAttribute("employee", employees);

    return "pagehome";
    }

    @PostMapping("/add")
    public String addEmpl(@RequestParam String name,@RequestParam String familie,@RequestParam int agee, Model model) {
        Employee employee = new Employee(name, familie, agee);
        emplRepository.save(employee);
        return "redirect:/";
    }
    @GetMapping("/add")
    public String addEmplGet (Model model){
       return "addList";
    }

    @GetMapping("/texts")
    public String textConvert (Model model){
        
       return "tesserAct";
    }


}
