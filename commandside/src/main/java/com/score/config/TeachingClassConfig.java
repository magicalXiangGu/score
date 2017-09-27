package com.score.config;


import com.score.aggregates.TeachingClass;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.spring.eventsourcing.SpringPrototypeAggregateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by zxp .
 */
@Configuration
public class TeachingClassConfig {

    @Autowired
    private EventStore eventStore;

    @Bean
    @Scope("prototype")
    public TeachingClass teachingClass(){
        return new TeachingClass();
    }

    @Bean
    public AggregateFactory<TeachingClass> teachingClassAggregateFactory(){
        SpringPrototypeAggregateFactory<TeachingClass> aggregateFactory = new SpringPrototypeAggregateFactory<>();
        aggregateFactory.setPrototypeBeanName("teachingClass");
        return aggregateFactory;
    }

    @Bean
    public Repository<TeachingClass> teachingClassAggregateRepository(){
        EventSourcingRepository<TeachingClass> repository = new EventSourcingRepository<TeachingClass>(
                teachingClassAggregateFactory(),
                eventStore
        );
        return repository;
    }
}
