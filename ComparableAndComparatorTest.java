import java.util.*;

//https://www.baeldung.com/java-comparator-comparable
public class ComparableAndComparatorTest {
    public static void main(String[] args) {

        Employee emp1 = new Employee(9,"nitin");
        Employee emp2 = new Employee(2,"rahul");
        Employee emp3 = new Employee(3,"shiv");
        Employee emp5 = new Employee(3,"aman");
        Employee emp4 = new Employee(6,"shakti");
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);

        System.out.println("Before Sorting : " + empList.toString());
        Comparator<Employee> rComparator = (Employee e1, Employee e2) -> e1.rollNo - e2.rollNo;
        System.out.println("");
        Collections.sort(empList, rComparator);
        System.out.println("After Sorting : " + empList);

        System.out.println("By comparator comparing method");
        //By java8 comparing method
        Comparator<Employee> byRollNo = Comparator
                .comparing(Employee::getRollNo);
        Comparator<Employee> byName = Comparator
                .comparing(Employee::getName);
        System.out.println("");
        Collections.sort(empList, byRollNo);
        System.out.println("After Sorting : " + empList);

        System.out.println("");
        Collections.sort(empList, byName);
        System.out.println("After Sorting : " + empList);

        ///2 field comparator
        Comparator<Employee> comparator2 = Comparator.comparing(emp -> emp.rollNo);
        comparator2 = comparator2.thenComparing(Comparator.comparing(emp -> emp.name)).reversed();

        System.out.println("");
        Collections.sort(empList, comparator2);
        System.out.println("After Sorting 2 fields : " + empList);

    }
}

class Employee {
    public int rollNo;

    @Override
    public String toString() {
        return "Employee{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getRollNo() == employee.getRollNo() &&
                getName().equals(employee.getName());
    }

    public Employee(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRollNo(), getName());
    }
}
