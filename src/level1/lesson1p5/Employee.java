package level1.lesson1p5;

/*
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 */
public class Employee {
    private String surname;
    private String name;
    private String middleName;
    private String position;
    private String email;
    private long telephone;
    private double salary;
    private int age;

     Employee() {
        this.surname = "Unknown";
        this.name = "Unknown";
        this.middleName = "Unknown";
        this.position = "Trainee";
        this.email = "Unknown";
        this.telephone = 927369966;
        this.salary = 15000.000;
        this.age = 18;
        showDataNewEmployee();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    Employee(String surname, String name, String middleName, String position, String email, int telephone, int salary, int age){
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;

        showDataNewEmployee();
    }

    public void showDataNewEmployee() {
        System.out.println("Новый соотрудник:");
        System.out.println(getSurname()+" "+getName()+" "+getMiddleName()+", "+getPosition());
    }

    public void showEmployeeInfo(){
        for (int i = 0; i < 90; i++) {
            System.out.print("_");
        }
        System.out.println();
        System.out.println(getSurname()+" "+getName()+" "+getMiddleName()+", "+getPosition()+", "+getEmail()+", "+getTelephone()+", "+getSalary()+", "+getAge());

    }
}
