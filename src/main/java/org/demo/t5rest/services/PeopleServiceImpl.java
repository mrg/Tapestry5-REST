package org.demo.t5rest.services;

import java.util.ArrayList;
import java.util.List;

import org.demo.t5rest.model.Person;

public class PeopleServiceImpl implements PeopleService
{
    private static List<Person> people;

    public PeopleServiceImpl()
    {
        people = new ArrayList<Person>();

        people.add(new Person("John", "Doe", 180, 60));
        people.add(new Person("Jane", "Doe", 120, 55));
        people.add(new Person("Tom", "Smith", 150, 59));
        people.add(new Person("Trudy", "Smith", 135, 57));
    }

    @Override
    public List<Person> getAllPeople()
    {
        return people;
    }
}
