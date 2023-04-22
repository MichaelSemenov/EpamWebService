package com.example.crudapplication.DAO;

import com.example.crudapplication.models.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;
    {
        people = new ArrayList<Person>();
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int index){
        return people.stream().filter(person -> person.getId() == index).findAny().orElse(null);
    }
    public void safe(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person person){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        System.out.println(person);
        System.out.println(personToBeUpdated);
    }
    public void delete(int id){
        people.removeIf(p-> p.getId() == id);
    }
}
