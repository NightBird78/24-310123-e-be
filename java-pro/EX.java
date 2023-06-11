import java.util.*;

public class EX {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Ian", "Green", 32, 4500);
        Employee employee2 = new Employee("Ebony", "Guerrero", 19, 2550);
        Employee employee3 = new Employee("Adnan", "Day", 21, 3800);
        Employee employee4 = new Employee("Rex", "Levy", 41, 5000);
        Employee employee5 = new Employee("Poppy", "Cunningham", 20, 4450);
        Employee employee6 = new Employee("Abbey", "Stephens", 35, 1480);
        Employee employee7 = new Employee("Carter", "Sutherland", 40, 2450);
        Employee employee8 = new Employee("Aayan", "Bennett", 39, 450);

        Generator generator = new Generator();
        List<Employee> employees = generator.generateEmployees(employee1, employee2, employee3, employee4,
                                                               employee5, employee6, employee7, employee8);
//        System.out.println(employees);


        DataBase dataBase = new DataBase();
        dataBase.addEmployees(employees);

        dataBase.printDataBase();
    }
}

class Employee {
    private String name;
    private String Surname;
    private Integer age;
    private Integer salary;

    public Employee(String name, String surname, Integer age, Integer salary) {
        this.name = name;
        Surname = surname;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(Surname, employee.Surname) && Objects.equals(age, employee.age) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Surname, age, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}


class Generator {
    public List<Employee> generateEmployees(Employee... employees) {
        List<Employee> list = new ArrayList<>(Arrays.asList(employees));
        return list;
    }
}

class DataBase {
    private final Map<Integer, Employee> dataBase;

    public DataBase() {
        dataBase = new TreeMap<>();
    }

    public void addEmployees(List<Employee> list) {
        int key = dataBase.size() + 1;

        for (Employee employee : list) {
            dataBase.put(key++, employee);
        }
    }

    public void printDataBase() {
        for (Map.Entry<Integer, Employee> entry : dataBase.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println("\t" + dataBase.get(entry.getKey()));
        }
    }

}
