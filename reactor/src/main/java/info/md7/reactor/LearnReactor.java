package info.md7.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearnReactor {

    public static void main(String[] args) {


        Mono<String> mono = Mono.just(UUID.randomUUID().toString());
        Flux<String> flux = Flux.just(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString()
        );
        Flux<Integer> range = Flux.range(1, 100);
        range.subscribe();
        Flux.<String>generate(sink -> {
            sink.next(UUID.randomUUID().toString());
        }).take(5).subscribe(System.out::println);

        Flux.generate(
                () -> 0,
                (state, sink) -> {
                    if (state > 1000) {
                        sink.complete();;
                    } else {
                        sink.next("Step: " + state);
                    }
                    return ++state;
                }
        ).subscribe(System.out::println);
    }

}
