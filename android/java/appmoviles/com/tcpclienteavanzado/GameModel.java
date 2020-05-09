package appmoviles.com.tcpclienteavanzado;

public class GameModel {
    public String name, studio, year;

    public GameModel(String name, String studio, String year){
        this.name = name;
        this.studio = studio;
        this.year = year;
    }

    public GameModel() {}

    public String getName(){
        return this.name;
    }

    public String getStudio(){
        return this.studio;
    }

    public String getYear(){
        return this.year;
    }
}