package chapter3;

import domain.Artist;
import domain.SampleData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;

public class Chapter3 {
    public static void main(String[] args) {
        var artists = Arrays.asList(new Artist("RRR", "Ru"),
                                    new Artist("EEE", "En"),
                                    new Artist("EE2", "En"));

        var threeArtists = SampleData.getThreeArtists();

        long count = threeArtists.stream()
                                 .filter(artist -> artist.isFrom("UK"))
                                 .count();

        System.out.println(count);

        List<String> letters = Stream.of("a", "b", "c")
                                     .collect(Collectors.toList());

        List<String> upper = Stream.of("a", "b", "c")
                                   .map(String::toUpperCase)
                                   .collect(Collectors.toList());

        List<String> withDigit = Stream.of("a", "2ef", "3bbb")
                                       .filter(s -> isDigit(s.charAt(0)))
                                       .collect(Collectors.toList());
    }
}
