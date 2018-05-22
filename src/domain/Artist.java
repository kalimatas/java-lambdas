package domain;

public class Artist {
    private String name;
    private String nationality;

    public Artist(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public boolean isFrom(String nationality) {
        return this.nationality.equals(nationality);
    }
}
