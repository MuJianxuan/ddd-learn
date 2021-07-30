package ddd.leave.domain.person.repository.facade;

import ddd.leave.infrastructure.po.PersonPO;

public interface PersonRepository {

    void insert(PersonPO personPO);

    void update(PersonPO personPO);

    PersonPO findById(String id);

    PersonPO findLeaderByPersonId(String personId);

}