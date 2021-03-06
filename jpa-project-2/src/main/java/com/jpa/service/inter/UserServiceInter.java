package com.jpa.service.inter;

import com.jpa.dao.Inter.*;
import com.jpa.model.User;
import com.jpa.model.UserInfo;
import java.util.List;

public interface UserServiceInter {

    boolean saveUser(final User user);

    boolean updateUser(final User user);

    boolean removeUser(final User user);

    User findById(final Integer id);

    User findUserByUsername(final String username);

    List<User> findUsers();

    int findUserCount();

    UserInfo findUserInfoByUsername(final String username);

}
