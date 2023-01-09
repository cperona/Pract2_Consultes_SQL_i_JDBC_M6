package mysqlconnection.database;

import java.util.List;

public interface CinemaInt {
    //SELECT * FROM Film
    void printAllFilms();
    //SELECT * FROM Film WHERE (YEAR(DataEstrena) BETWEEN 1980 AND 1990)
    void printMoviesBetween(String year1, String year2);
    //SELECT Titol, year(DataEstrena) FROM Film where director = '~'
    void printMoviesByDirector(String Nom);
    //INSERT INTO Film (Titol, DataEstrena, Pais, idDirector) Values(~);
    void insertFilm(Film film);
}