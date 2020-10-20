package com.kt.jspjdbc.gestor.model.group;

import java.util.List;

public interface GroupDAO {

    void register(String s);

    void save(Group group);

    void update(Group group);

    void delete(String id);

    Group find(String id);

    List<Group> findAll();

}
