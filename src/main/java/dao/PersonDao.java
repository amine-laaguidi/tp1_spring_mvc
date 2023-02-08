package dao;

import entities.Person;

import java.util.List;

public interface PersonDao {
     Person addPerson(Person p) throws Exception;
     Person updatePerson(Person p) throws Exception;
     Person deletePerson(Person p) throws Exception;
     Person getPerson(long id) throws Exception;
     List<Person> getAll() throws Exception;

}
