package com.stackroute.prefill;


import com.stackroute.domain.MovieApp;
import com.stackroute.repository.MovieAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerDemo implements ApplicationListener<ContextRefreshedEvent> {



     @Autowired
    private MovieAppRepository movieAppRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        seedData();

    }
    private void seedData(){

    }
}
