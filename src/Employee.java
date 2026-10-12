public class Employee {

    private String surname;
    private String name;
    private String patronymic;
    private int department;
    private float wages;
    private int id;

    public Employee (String surname, String name, String patronymic, int department, float wages, int id) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.wages = wages;
        this.id = id;
    }

    public String getSurname () {
        return this.surname;
    }

    public String getName () {
        return this.name;
    }

    public String getPatronymic () {
        return this.patronymic;
    }

    public int getDepartment () {
        return this.department;
    }

    public float getWages () {
        return this.wages;
    }

    public int getId () {
        return this.id;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setDepartment (int department) {
        this.department = department;
    }

    public void setWages (float wages) {
        this.wages = wages;
    }

    @Override
    public String toString () {
        return "ID: " + this.getId() + "\nФ.И.О.: " + this.getSurname() + " " + this.getName() + " " + this.getPatronymic() + "\nЗарплата: " + this.getWages() + "\nОтдел № " + this.getDepartment();
    }

    public String printShortInfo () {
        return "Ф.И.О.: " + this.getSurname() + " " + this.getName() + " " + this.getPatronymic() + "\nЗарплата: " + this.getWages();
    }

    @Override
    public int hashCode () {
        return java.util.Objects.hash(this.toString());
    }

    public boolean equals (Employee employee) {
        if (this.getClass() != employee.getClass()) {
            return false;
        }
        return this.getWages() == employee.getWages();
    }

}
