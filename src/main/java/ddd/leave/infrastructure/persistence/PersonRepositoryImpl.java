package ddd.leave.infrastructure.persistence;

import ddd.leave.infrastructure.po.PersonPO;
import ddd.leave.infrastructure.facade.PersonRepository;
import ddd.leave.infrastructure.mapper.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    PersonDao personDao;

    @Override
    public void insert(PersonPO personPO) {
        personDao.save(personPO);
    }

    @Override
    public void update(PersonPO personPO) {
        personDao.save(personPO);
    }

    @Override
    public PersonPO findById(String id) {
        return personDao.findById(id).orElseThrow(() -> new RuntimeException("未找到用户"));
    }

    @Override
    public PersonPO findLeaderByPersonId(String personId) {
        return personDao.findLeaderByPersonId(personId);
    }

}