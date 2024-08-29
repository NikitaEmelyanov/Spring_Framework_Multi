package model;

import jakarta.persistence.*;

@Entity
@Table (name = "Movie")
public class Movies {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    @Column(name = "name")
    private String movieName;
    @Column(name = "year_of_production")
    private int yearOfProduction;

    @Column(name = "director_id")
    private int directorId;

    @ManyToOne
    @JoinColumn(name = "director_id",referencedColumnName = "movie_id")
    private Director owner;



    public Movies(){}

    public Movies(String movieName, int yearOfProduction, Director owner) {
        this.movieName = movieName;
        this.yearOfProduction = yearOfProduction;
        this.owner = owner;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Director getOwner() {
        return owner;
    }

    public void setOwner(Director owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movie_id=" + movie_id +
                ", movieName='" + movieName + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}


