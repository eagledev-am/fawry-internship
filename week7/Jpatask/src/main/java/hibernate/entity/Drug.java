package hibernate.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "drugs")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "gen")
    @TableGenerator(name = "gen" , initialValue = 300 , allocationSize = 1)
    @Column(name = "drug_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "patients_drugs" ,
            joinColumns = @JoinColumn(name = "drug_id" ) ,
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<Patient> patients;


    public Drug(){
        patients = new HashSet<>();
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Set<Patient> getPatients() {
        return patients;
    }


    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }


    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drug)) return false;
        Drug drug = (Drug) o;
        return getId() == drug.getId() && Objects.equals(getName(), drug.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }


}
