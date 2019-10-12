package com.stackroute.prefill;


import com.stackroute.domain.MovieApp;
import com.stackroute.repository.MovieAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner {

    @Autowired
    private MovieAppRepository movieAppRepository;
    @Override
    public void run(String... args) throws Exception {
        seedData();
    }
    private void seedData(){


    }
}
