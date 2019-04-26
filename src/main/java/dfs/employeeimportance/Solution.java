package dfs.employeeimportance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    private Map<Integer, Employee> employeeById = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee e : employees) {
            employeeById.put(e.id, e);
        }
        return dfs(employeeById.get(id));
    }

    private int dfs(Employee employee) {
        if (employee == null) {
            return 0;
        }
        int importance = employee.importance;
        if (employee.subordinates == null) {
            return importance;
        }
        for (Integer e : employee.subordinates) {
            importance += dfs(employeeById.get(e));
        }
        return importance;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
}
