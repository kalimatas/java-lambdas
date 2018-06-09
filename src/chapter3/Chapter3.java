package chapter3;

import domain.Artist;
import domain.SampleData;
import domain.Track;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;

public class Chapter3 {
    public static void main(String[] args) {
        var artists = asList(new Artist("RRR", "Ru"),
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

        List<Integer> digits = Stream.of(asList(1, 2, 3), asList(4, 5, 6))
                                     .flatMap(Collection::stream)
                                     .collect(Collectors.toList());

        List<Track> tracks = asList(new Track("first", 1),
                                    new Track("second", 23),
                                    new Track("third", 12));

        Track shortest = tracks.stream()
                               .min(Comparator.comparing(Track::getLength))
                               .get();

        System.out.println(shortest.getName());

        int reducedCount = Stream.of(1, 2, 3)
                                 .reduce(0, (acc, e) -> acc + e);
        System.out.println(reducedCount);

        Set<String> origins = SampleData.beatlesAlbum
                                      .getMusicians()
                                      .filter(artist -> artist.getName().startsWith("The"))
                                      .map(Artist::getNationality)
                                      .collect(Collectors.toSet());

        origins.forEach(System.out::println);
    }
}
