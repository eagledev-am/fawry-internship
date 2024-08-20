package hibernate.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "doctors")
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "gen" )
    @TableGenerator(name = "gen" , initialValue = 200 , allocationSize = 1)
    @Column(name = "doctor_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "specialty")
    private String specialty;


    @ManyToOne
    @JoinColumn(name = "hospital_id" , referencedColumnName = "hospital_id")
    private Hospital hospital;

    @ManyToMany
    @JoinTable(
            name = "doctors_patients" ,
            joinColumns = @JoinColumn(name = "doctor_id") ,
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<Patient> patients;


    public Doctor(){
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", hospital=" + hospital +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return getId() == doctor.getId() && Objects.equals(getName(), doctor.getName()) && Objects.equals(getSpecialty(), doctor.getSpecialty()) && Objects.equals(getHospital(), doctor.getHospital());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSpecialty(), getHospital());
    }

}
