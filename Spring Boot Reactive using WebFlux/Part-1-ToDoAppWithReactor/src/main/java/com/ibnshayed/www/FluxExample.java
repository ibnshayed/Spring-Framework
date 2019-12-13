package com.ibnshayed.www;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Configuration
public class FluxExample {
    static private Logger LOG = LoggerFactory.getLogger(FluxExample.class);

    @Bean
    public CommandLineRunner runFluxExample(){
        return args -> {
            EmitterProcessor<ToDo> strem = EmitterProcessor.create();
            Mono<List<ToDo>> promise = strem
                    .filter(s-> s.isCompleted())
                    .doOnNext(s -> LOG.info("FLUX >>> ToDO: {}",s.getDescription()))
                    .collectList()
                    .subscribeOn(Schedulers.single());

            strem.onNext(new ToDo("Read a Book",true));
            strem.onNext(new ToDo("Workout in the morning"));
            strem.onNext(new ToDo("Organize my room",true));
            strem.onNext(new ToDo("Go to the car wash",true));
            strem.onNext(new ToDo("SP1 2018 is coming",true));

            strem.onComplete();
            promise.block();
        };
    }
}
