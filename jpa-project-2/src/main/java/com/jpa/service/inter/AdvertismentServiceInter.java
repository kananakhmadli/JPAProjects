package com.jpa.service.inter;

import com.jpa.dao.Inter.*;
import com.jpa.model.Advertisment;
import java.util.List;

public interface AdvertismentServiceInter {

    boolean saveAdvertisment(final Advertisment advertisment);

    boolean updateAdvertisment(final Advertisment advertisment);

    boolean removeAdvertisment(final Advertisment advertisment);

    Advertisment findById(final Integer id);

    List<Advertisment> findByUsername(final String username);

    List<Advertisment> findAdvertisment();

}
