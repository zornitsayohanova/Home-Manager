import java.util.HashSet;

public class Company
{
    private String companyName;
    private String companyOwner;
    private static HashSet<Employee> companyEmployees;

    Company()
    {
        companyName = "";
        companyOwner = "";
        companyEmployees = new HashSet<Employee>();
    }

    Company(String companyName, String companyOwner) {
        this.companyName = companyName;
        this.companyOwner = companyOwner;
        companyEmployees = new HashSet<Employee>();
    }

    public void SetCompanyOwner(String companyOwner) {
        this.companyOwner = companyOwner;
    }

    public void SetCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String GetCompanyOwner() {
        return companyOwner;
    }

    public String GetCompanyName() {
        return companyName;
    }

    public void AddEmployee(Employee employee) {
        companyEmployees.add(employee);
    }

    public void AddEmployees(HashSet<Employee> employees) {
        companyEmployees.addAll(employees);
    }

    public void ShowAllEmployees() {
        companyEmployees.forEach(System.out::println);
    }
}
