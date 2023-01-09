package mysqlconnection.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cinema implements CinemaInt{

    private Connection connection;

    public Cinema() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cinema?&serverTimezone=UTC";
        String user = "root";
        String password = "root";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printAllFilms() {
        System.out.println(selectStatement("select * from Film"));
    }

    @Override
    public void printMoviesBetween(String year1, String year2) {
        System.out.println(String.format("---Pel·lícules entre %s i %s", year1, year2));
        System.out.println(selectStatement(String.format("select * from Film where year(DataEstrena) between year('%s-1-1') and year('%s-1-1')", year1, year2)));
    }

    @Override
    public void printMoviesByDirector(String Nom) {
        System.out.println(String.format("---Pel·lícules del director %s", Nom));
        System.out.println(selectStatement(String.format("select Titol, year(DataEstrena) from Film where idDirector in(select idDirector from Director where Nom = '%s')", Nom)));
    }

    @Override
    public void insertFilm(Film film) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("select * from Film where Titol = '%s'", film.getTitol()));
            if (resultSet.next()) {
                System.out.println(String.format("---No es pot inserir la pel·lícula %s. La pelicula ja existeix", film.getTitol()));
            } else {
                updateStatement(String.format("INSERT INTO Film (Titol, DataEstrena, Pais, idDirector) " +
                        "Values('%s','%s','%s', %d)", film.getTitol(), film.getDataEstrena(), film.getPais(), film.getIdDirector()));
                System.out.println(String.format("---Inserida la pel·lícula %s", film.getTitol()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String selectStatement(String select) {
        StringBuilder result = new StringBuilder();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            int colNum = getColumnNames(resultSet);
            if(colNum>0) {
                while(resultSet.next()) {
                    for(int i =0; i<colNum; i++) {
                        if(i+1 == colNum) {
                            result.append(resultSet.getString(i + 1));
                        } else {
                            result.append(resultSet.getString(i + 1)).append(", ");
                        }
                    }
                    result.append("\n");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }

    public void updateStatement(String st) {
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(st);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getColumnNames(ResultSet rs) throws SQLException {
        int numberOfColumns = 0;
        if (rs != null) {
            //create an object based on the Metadata of the result set
            ResultSetMetaData rsMetaData = rs.getMetaData();
            //Use the getColumn method to get the number of columns returned
            numberOfColumns = rsMetaData.getColumnCount();
            //get and print the column names, column indexes start from 1
            for (int i = 1; i < numberOfColumns + 1; i++) {
                String columnName = rsMetaData.getColumnName(i);
                System.out.print(columnName + ", ");
            }//endfor
        }//endif
        //place the cursor on a new line in the console
        System.out.println();
        return numberOfColumns;
    }
}
