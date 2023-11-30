package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private int PERSON_COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++PERSON_COUNT, "Kate"));
        people.add(new Person(++PERSON_COUNT, "Leo"));
        people.add(new Person(++PERSON_COUNT, "Max"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PERSON_COUNT);
        people.add(person);
    }
}
