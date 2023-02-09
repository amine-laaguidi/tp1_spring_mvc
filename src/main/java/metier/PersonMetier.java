package metier;

import entities.Person;

import java.util.List;

public interface PersonMetier {
    Person subscribe(Person person) throws Exception;
    Person EditProfile(Person person) throws Exception;
    Person DeletePerson(Person person) throws Exception;
    Person getPerson(long id) throws Exception;
    List<Person> getAll() throws Exception;

}
