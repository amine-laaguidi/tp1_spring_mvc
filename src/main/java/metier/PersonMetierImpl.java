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
        if(!person.getEmail().contains("@gmail.com"))
            throw new Exception("email not authorized");
        return dao.addPerson(person);
    }

    @Override
    public Person EditProfile(Person person) throws Exception {
        return dao.updatePerson(person);
    }

    @Override
    public Person DeletePerson(Person person) throws Exception {
        return dao.deletePerson(person);
    }

    @Override
    public Person getPerson(long id) throws Exception {
        return dao.getPerson(id);
    }

    @Override
    public List<Person> getAll() throws Exception {
        return dao.getAll();
    }


}
