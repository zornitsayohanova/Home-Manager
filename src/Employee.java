import java.util.HashSet;

public class Employee extends Person
{
    private String employeeID;
    private int maxBuildingsAmount;

    HashSet<Building> employeeBuildingsList;

    public Employee()
    {
        super();
        employeeID = "";
        maxBuildingsAmount = 0;
        employeeBuildingsList = new HashSet<Building>();
    }

    public Employee(String employeeName, int employeeAge, String employeeNationality,
                    Gender employeeGender, String employeeID)
    {
        super(employeeName, employeeAge, employeeNationality, employeeGender);
        this.employeeID = employeeID;
        maxBuildingsAmount = 0;
        employeeBuildingsList = new HashSet<Building>();
    }

    public void SetPersonName(String employeeName)
    {
        personName = employeeName;
    }

    public void SetPersonAge(int employeeAge)
    {
        personAge = employeeAge;
    }

    public void SetPersonNationality(String employeeNationality)
    {
        personNationality = employeeNationality;
    }

    public void SetPersonGender(Gender employeeGender)
    {
        personGender = employeeGender;
    }

    public void SetEmployeeID(String employeeID)
    {
        this.employeeID = employeeID;
    }

    public void SetMaxBuildingsAmount(int maxBuildingsAmount)
    {
        this.maxBuildingsAmount = maxBuildingsAmount;
    }

    public String GetPersonName()
    {
        return personName;
    }

    public int GetPersonAge()
    {
        return personAge;
    }

    public String GetPersonNationality()
    {
        return personNationality;
    }

    public Gender GetPersonGender()
    {
        return personGender;
    }

    public String GetEmployeeID()
    {
        return employeeID;
    }

    public int GetMaxBuildingsAmount()
    {
        return maxBuildingsAmount;
    }

    public HashSet<Building> GetEmployeeBuildingsList()
    {
        return employeeBuildingsList;
    }

    public void AddToBuildingsList(Building building)
    {
        employeeBuildingsList.add(building);
    }

    public void ShowBuildingsList()
    {
        employeeBuildingsList.forEach(System.out::println);
    }

    @Override
    public String toString()
    {
        return super.toString() + ("Employee ID: " + employeeID);
    }
}
