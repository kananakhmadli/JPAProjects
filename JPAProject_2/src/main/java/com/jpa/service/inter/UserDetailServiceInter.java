package com.jpa.service.inter;

import com.jpa.model.UserDetail;

public interface UserDetailServiceInter {

    boolean saveUserDetail(final UserDetail userDetail);

    boolean updateUserDetail(final UserDetail userDetail);

    boolean removeUserDetail(final UserDetail userDetail);

    UserDetail findById(final Integer id);

    UserDetail findUserByUsername(final String username);

    UserDetail findWithAddressByUsername(final String username);
}
