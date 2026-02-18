package com.smartcontactman.SmartContactManager.repository;

import com.smartcontactman.SmartContactManager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface UserRepository  extends JpaRepository <User,String> {
}
