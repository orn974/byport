package by.mts.brest.java.byport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, familie;
    private int agee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilie() {
        return familie;
    }

    public void setFamilie(String familie) {
        this.familie = familie;
    }

    public int getAgee() {
        return agee;
    }

    public void setAgee(int agee) {
        this.agee = agee;
    }

    public Employee() {
    }

    public Employee(String name, String familie, int agee) {
        this.name = name;
        this.familie = familie;
        this.agee = agee;
    }
}
