package com.rcs.spring.cms;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.rcs.spring.cms.domain.entities.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

public class RandomTest {

    @Test
    public void coldBehaviour() throws InterruptedException {
        Category sports = Category.builder().build();
        sports.setId(UUID.randomUUID().toString());
        sports.setName("sports");

        Category music = Category.builder().build();
        music.setId(UUID.randomUUID().toString());
        music.setName("music");

        Flux<Category> coldFlux = Flux.just(sports, music)
            .doOnNext(System.out::println);

        TimeUnit.SECONDS.sleep(2);

        coldFlux.subscribe();
    }

    @Test
    public void testHotPublisher() {
        UnicastProcessor<String> hotSource = UnicastProcessor.create();

        Flux<Category> hotPublisher = hotSource.publish().autoConnect()
            .map((String t) -> Category.builder().name(t).build());

        hotSource.onNext("entertainment");

        hotPublisher.subscribe(category -> System.out.println("Subscriber 1: " + category.getName()));
        hotSource.onNext("sports");
        hotSource.onNext("cars");

        hotPublisher.subscribe(category -> System.out.println("Subscriber 2: " + category.getName()));
        hotSource.onNext("games");
        hotSource.onNext("electronics");
        hotSource.onComplete();
    }
}
