package hibernate.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "gen")
    @TableGenerator(name = "gen" , initialValue = 400 , allocationSize = 1)
    @Column(name = "patient_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToMany(mappedBy = "patients")
    private Set<Doctor> doctors;

    @ManyToMany(mappedBy = "patients")
    List<Drug> drugs;

    public Patient(){
        doctors = new HashSet<>();
        drugs = new ArrayList<>();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hospital=" + hospital +
                ", drugs=" + drugs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getId() == patient.getId() && getAge() == patient.getAge() && Objects.equals(getName(), patient.getName()) && Objects.equals(getHospital(), patient.getHospital());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getHospital());
    }

}
