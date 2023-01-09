package mysqlconnection.database;

public class Film {
    private int idFilm;
    private String Titol;
    private String DataEstrena;
    private String Pais;
    private int idDirector;

    public Film(String titol, String dataEstrena, String pais, int idDirector) {
        Titol = titol;
        DataEstrena = dataEstrena;
        Pais = pais;
        this.idDirector = idDirector;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitol() {
        return Titol;
    }

    public void setTitol(String titol) {
        Titol = titol;
    }

    public String getDataEstrena() {
        return DataEstrena;
    }

    public void setDataEstrena(String dataEstrena) {
        DataEstrena = dataEstrena;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }
}
