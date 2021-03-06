package com.jpa.service.inter;

import com.jpa.dao.Inter.*;
import com.jpa.model.Education;
import java.util.List;

public interface EducationServiceInter {

    boolean saveEducation(final Education education);

    boolean updateEducation(final Education education);

    boolean removeEducation(final Education education);

    Education findById(final Integer id);

    List<Education> findEducations();

    Education findWithAdvertismentById(final Integer id);

}
