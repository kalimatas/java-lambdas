package chapter3;

import domain.Album;
import domain.Artist;
import domain.SampleData;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class Chapter5 {
    public static void main(String[] args) {
        List<Integer> numbers = asList(1, 2, 3);
        List<Integer> same = numbers.stream().collect(Collectors.toList());

        Set<Integer> nums = new HashSet<>(asList(1, 2, 3, 4));
        List<Integer> maybeSame = nums.stream().collect(Collectors.toList());
        maybeSame.forEach(System.out::println);

        // max members
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        Optional<Artist> artist = SampleData.threeArtists().collect(maxBy(Comparator.comparing(getCount)));
        System.out.println(artist.orElseThrow().getName());

        // average tracks
        System.out.println(SampleData.albums
                                   .collect(averagingInt(album -> album.getTrackList().size())));

        var albums = asList(SampleData.sampleShortAlbum, SampleData.aLoveSupreme, SampleData.beatlesAlbum);

        albumsByArtist(albums.stream())
                .values()
                .forEach(l -> { System.out.println(l.stream().map(Album::getName).collect(joining(", ", "[", "]"))); });

    }

    private static Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(partitioningBy(Artist::isSolo));
    }

    private static Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician));
    }

    private static Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician, counting()));
    }

    private static Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician, mapping(Album::getName, toList())));
    }
}
