package com.smartcontactman.SmartContactManager.repository;

import com.smartcontactman.SmartContactManager.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "contact")
public interface ContactRepository  extends JpaRepository<Contact,String> {

    Contact findByemail(String email);
    Contact findByphonenumber(String phonenumber);
    @RestResource(path="by-name")
    List<Contact>findByNameContainingIgnoreCase(@Param("name")String name);

}
