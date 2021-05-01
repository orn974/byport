package by.mts.brest.java.byport.controllers;

import by.mts.brest.java.byport.EmplRepository;
import by.mts.brest.java.byport.Emploee;
import by.mts.brest.java.byport.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
public class mainController {

    @Autowired
    private EmplRepository emplRepository;
    RestTemplate restTemplate;

    final String ROOT_URL = "http://localhost:8090/";
    @GetMapping ("/empl")
    public String getAllPerson(Model model) {
        restTemplate=new RestTemplate();
        ResponseEntity<Emploee[]> response = restTemplate.getForEntity(ROOT_URL, Emploee[].class);
        Emploee[] responseList = response.getBody();
        model.addAttribute("response", responseList);
        // return Arrays.asList(response.getBody());
        return "PageEmploees";
    }
    @GetMapping("/emplRepo")
    public String EmploesRepo (Model model){
        restTemplate=new RestTemplate();
        ResponseEntity<Emploee[]> responseRepo = restTemplate.getForEntity(ROOT_URL+"/emploes", Emploee[].class);
        Emploee[] responsRepo = responseRepo.getBody();
        model.addAttribute("responseRepo", responsRepo);
        return "PageEmploees";
    }

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

    @PutMapping("/putempl")
    public String updateEmployee()
    {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("ig","1");

        Employee updateEmploee = new Employee( "Adam", "Gilly", "Serg","11.22.33");
        restTemplate.put(ROOT_URL+"/emloees/{id}",updateEmploee,params);

        WebClient webClient;
//
//        public Mono<Employee> update(Employee e)
//        {
//            return webClient.put()
//                    .uri("/employees/" + e.getId())
//                    .body(Mono.just(e), Employee.class)
//                    .retrieve()
//                    .bodyToMono(Employee.class);
//        }

        return "redirect:/";
    }

//    @PostMapping("/putempl")
//    public String postEmployee(@RequestParam String name,@RequestParam String surname, @RequestParam String patronymic, @RequestParam String afterbirth)
//    {
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("ig","1");
//
//        Employee updateEmploee = new Employee( name, surname, patronymic, afterbirth);
//        restTemplate.put(ROOT_URL+"/emloees/{id}",updateEmploee,params);
//    return "PageEmpliees";
//

}
