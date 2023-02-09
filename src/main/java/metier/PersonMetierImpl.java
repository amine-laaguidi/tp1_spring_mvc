package metier;

import dao.PersonDao;
import dao.PersonDaoImpl;
import entities.Person;

import java.util.List;

public class PersonMetierImpl implements PersonMetier {
    private PersonDao dao;
    public void setDao(PersonDao dao) {
        this.dao = dao;
    }

    public PersonMetierImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person subscribe(Person person) throws Exception {
        return null;
    }

    @Override
    public Person EditProfile(Person person) throws Exception {
        return null;
    }

    @Override
    public Person DeletePerson(Person person) throws Exception {
        return null;
    }

    @Override
    public Person getPerson(long id) throws Exception {
        return null;
    }

    @Override
    public List<Person> getAll() throws Exception {
        return null;
    }


}
