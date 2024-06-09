package Project_1.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "ФИО не должно быть пустым ")
    @Size(min = 2, max = 100, message = "ФИО должно быть от 2 до 100 символов")
    private String fullName;
    @Min(value = 1900, message = "Год рождения должен быть больше чем 1900")
    private int yearOfBird;

    public Person(String name, int yearOfBird) {
        this.fullName = name;
        this.yearOfBird = yearOfBird;
    }

    public Person() { // Пустой конструктор для Spring

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBird() {
        return yearOfBird;
    }

    public void setYearOfBird(int yearOfBird) {
        this.yearOfBird = yearOfBird;
    }

    }
