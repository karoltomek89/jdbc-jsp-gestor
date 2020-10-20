package com.kt.jspjdbc.gestor.model.user;

import com.kt.jspjdbc.gestor.model.Membership;

import java.util.List;

public interface UserDAO {

    void register(String name, String surname, String email, String password, Membership membership);

    void save(User user);

    void update(User user);

    void delete(String userId);

    User findById(String userId);

    int login(String email, String password);

    List<User> findAll();

    List<User> findAllByMembership(Membership membership);

    String getEmail(String userId);

    int getMembershipId(int userId);

    Membership getMembershipById(int membershipId);

    int getUserId(User user);

    int getUserGroupId(String userId);

    List<User> findAllByGroup(String groupId);
}
