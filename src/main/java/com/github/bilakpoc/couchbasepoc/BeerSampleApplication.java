package com.github.bilakpoc.couchbasepoc;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.github.bilakpoc.couchbasepoc.persistence.couchbase.repository.BeerRepository;

@SpringBootApplication
public class BeerSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerSampleApplication.class, args);
    }


    @Component
    static class Tester implements ApplicationListener<ApplicationReadyEvent> {

        private final BeerRepository beerRepository;

        Tester(final BeerRepository beerRepository) {
            this.beerRepository = beerRepository;
        }

        @Override
        public void onApplicationEvent(final ApplicationReadyEvent applicationReadyEvent) {
            final CountDownLatch latch = new CountDownLatch(1);

            beerRepository.findAll()
                    .doOnComplete(latch::countDown)
                    .doOnError(error -> latch.countDown())
                    .subscribe(beer -> System.out.println("Found beer " + beer),
                            error -> error.printStackTrace(),
                            () -> System.out.println("finished"));

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("This is the end");
        }
    }
}
