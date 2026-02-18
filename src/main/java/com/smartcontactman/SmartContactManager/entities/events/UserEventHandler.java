package com.smartcontactman.SmartContactManager.entities.events;

import com.smartcontactman.SmartContactManager.entities.User;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import java.util.UUID;
import java.util.logging.Logger;


@RepositoryEventHandler({User.class})
public class UserEventHandler {

    private Logger log= (Logger) LoggerFactory.getLogger(UserEventHandler.class);

    @HandleBeforeCreate
    public void handleBeforeCreate(User user){
        log.info("Going to user creating..");
        user.setId(Long.valueOf(UUID.randomUUID().toString()));
    }
}

