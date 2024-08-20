package task.entity;

public class Doctor {
    private int id;
    private String name;
    private String specialty;
    private int hospital_id;

    public Doctor(){

    }

    public Doctor(int id, String name, String specialty, int hospital_id) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.hospital_id = hospital_id;
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

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", hospital_id=" + hospital_id +
                '}';
    }
}
