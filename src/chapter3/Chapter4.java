package chapter3;

import java.util.Optional;

public class Chapter4 {
    public static void main(String[] args) {
        Optional<String> a = Optional.of("a");
        System.out.println(a.get());

        Optional empty = Optional.empty();
        System.out.println(empty.orElse("hello"));
        System.out.println(empty.orElseGet(() -> "hello lambda"));
    }
}
