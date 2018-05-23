package chapter3;

import domain.Artist;
import domain.SampleData;

import java.util.Arrays;

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
    }
}
