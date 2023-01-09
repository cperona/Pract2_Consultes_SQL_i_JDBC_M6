package mysqlconnection;

import mysqlconnection.database.*;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.printMoviesBetween("1990", "2013");
        cinema.printMoviesByDirector("Steven Spielverg");
        cinema.insertFilm(new Film("Avatar 2", "2022-12-29", "Estats Units", 1));
        cinema.insertFilm(new Film("Avatar 2", "2022-12-29", "Estats Units", 1));
    }
}
