package by.mts.brest.java.byport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emploee {
    public Emploee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;                // Имя              name
    private String surname;             // Фамилия          surName
    private String patronymic;          // Отчество         middleName
    private String afterbirth;          // Дата рожждения   birthDay        // Date?

    public Emploee(String name, String surname, String patronymic, String afterbirth) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.afterbirth = afterbirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAfterbirth() {
        return afterbirth;
    }

    public void setAfterbirth(String afterbirth) {
        this.afterbirth = afterbirth;
    }
}
