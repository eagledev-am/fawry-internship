package task.entity;

public class Patient {
    private int id;
    private String name;
    private int age;

    private int hospitalId;


    public Patient(){

    }
    public Patient(int id, String name, int age, int hospital_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hospitalId = hospital_id;
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

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hospitalId=" + hospitalId +
                '}';
    }
}
