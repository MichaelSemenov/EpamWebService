package com.example.crudapplication.controllers;


import com.example.crudapplication.DAO.PersonDAO;
import com.example.crudapplication.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleControllers {

    @Autowired
    private final PersonDAO personDAO;

    public PeopleControllers( PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "index";
    }

    @GetMapping("/{id}")

    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){          //Так же можно использовать (@ModelAttribute("person") Person person)
        model.addAttribute("person", new Person());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
         personDAO.safe(person);
         return "redirect:/people/index";       //Для перенаправления по URL - rederict
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person,
                         @PathVariable("id") int id) {
        personDAO.update(id, person);
        return "redirect:/people/index";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
            personDAO.delete(id);
            return "redirect:/people/index";
    }
}
