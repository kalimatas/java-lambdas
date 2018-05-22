package chapter3;

import domain.Artist;

import java.util.Arrays;

public class Chapter3 {
    public static void main(String[] args) {
        var artists = Arrays.asList(new Artist("RRR", "Ru"),
                                    new Artist("EEE", "En"),
                                    new Artist("EE2", "En"));

        long count = artists.stream()
                            .filter(artist -> artist.isFrom("En"))
                            .count();

        System.out.println(count);
    }
}