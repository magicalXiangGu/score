package com.score.handlers;

import com.score.commands.CreateTeachingClassCommand;
import com.score.events.TeachingClassCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;

public class TeachingClassCommandHandler {


    @CommandHandler
    public void handler(CreateTeachingClassCommand command){

    }
}
