package web;

import entities.Person;
import metier.PersonMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/peoples")
public class PersonController {

    private PersonMetier metier ;

    public PersonController(PersonMetier metier) {
        this.metier = metier;
    }
    @GetMapping("")
    public String ListPerson(Model model) {
        try{
            List<Person> peoples = metier.getAll();
            model.addAttribute("peoples",peoples);
            if(!model.containsAttribute("person"))
                model.addAttribute("person",null);
            if(!model.containsAttribute("err"))
                model.addAttribute("err",null);
            if(!model.containsAttribute("delName"))
                model.addAttribute("delName",null);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return "peoples";
    }
    @PostMapping()
    public void addPerson(@ModelAttribute Person person,Model model){
          try{
              Person p = metier.subscribe(person);
              model.addAttribute("person",p);
          } catch (Exception e) {
              model.addAttribute("err",1);
          }
          this.ListPerson(model);
    }
    @RequestMapping(value = "delete/{id}" ,method = RequestMethod.GET)
    public void deletePost(@PathVariable(value="id") Long id,Model model) {
        try{
            Person person = metier.DeletePerson(metier.getPerson(id));
            model.addAttribute("delName",person.getName());
        }catch (Exception e){
            model.addAttribute("err",2);
        }
        this.ListPerson(model);
    }
}
