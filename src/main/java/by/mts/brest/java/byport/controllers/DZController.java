package by.mts.brest.java.byport.controllers;

import by.mts.brest.java.byport.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class DZController {
    final String ROOT_URL_DZ = "http://192.168.3.220:8090/";
    RestTemplate restTemplate;
    @GetMapping ("/dz")
    public String dzGet (Model model){
        restTemplate=new RestTemplate();
        ResponseEntity<Employee[]> person = restTemplate.getForEntity(ROOT_URL_DZ, Employee[].class);
        Employee[] pageList = person.getBody();
        model.addAttribute("dzperson", pageList);
        return "DZPage";
    }
}
