package Exercise.Stream;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exercise.Stream
 *
 * @author plusman
 * @since 2020/9/19
 */
public class groupByDemo {
    private static class Employee {
        String department;
        Integer salary;

        public Employee(String department, Integer salary) {
            this.department = department;
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public Integer getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("A", 10);
        Employee employee2 = new Employee("B", 20);
        Employee employee3 = new Employee("A", 30);
        List<Employee> list = new LinkedList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);


        Map<String, Integer> table = list.stream()
            .collect(Collectors.groupingByConcurrent(
                Employee::getDepartment,
                Collectors.summingInt(Employee::getSalary)
            ));

        System.out.println(table);
    }
}
