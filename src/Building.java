import java.util.*;

public class Building
{
    private String address;
    private int builtYear;
    private double totalArea;
    private double livingArea;
    private double mutualArea;
    private int floorsAmount;
    protected int apartmentsAmount;
    protected int buildingResidentsAmount;
    protected enum Material
    {
        BRICKS, CONCRETE, CEMENT, PANEL, UNSET;
    }

    Material material;
    Employee employee;
    protected static List<Apartment> apartments;
    protected HashMap<Apartment,Boolean> apartmentsFeeStatus;

    public Building()
    {
        address = "";
        material = Material.UNSET;
        builtYear = 0;
        totalArea = 0.0;
        livingArea = 0.0;
        mutualArea = 0.0;
        floorsAmount = 0;
        apartmentsAmount = 0;
        buildingResidentsAmount = 0;
        apartments = new ArrayList<Apartment>();
        apartmentsFeeStatus = new HashMap<Apartment, Boolean>();
    }

    public Building(String address, Material material, int builtYear,
                    double totalArea, double livingArea, double mutualArea,
                    int floorsAmount, int apartmentsAmount)
    {
        this.address = address;
        this.material = material;
        this.builtYear = builtYear;
        this.totalArea = totalArea;
        this.livingArea = livingArea;
        this.mutualArea = mutualArea;
        this.floorsAmount = floorsAmount;
        this.apartmentsAmount = apartmentsAmount;
        apartments = new ArrayList<Apartment>();
        apartmentsFeeStatus = new HashMap<Apartment, Boolean>();
    }

    public void SetBuildingAddress(String address)
    {
       this.address = address;
    }

    public void SetBuildingMaterial(Material material)
    {
        this.material = material;
    }

    public void SetBuildingAge(int builtYear)
    {
        this.builtYear = builtYear;
    }

    public void SetBuildingTotalArea(double totalArea)
    {
        this.totalArea = totalArea;
    }

    public void SetBuildingUsedArea(double livingArea)
    {
        this.livingArea = livingArea;
    }

    public void SetBuildingMutualArea(double mutualArea)
    {
        this.mutualArea = mutualArea;
    }

    public void SetFloorsAmount(int floorsAmount)
    {
        this.floorsAmount = floorsAmount;
    }

    public void SetApartmentsAmount(int apartmentsAmount)
    {
        this.apartmentsAmount = apartmentsAmount;
    }

    public void SetBuildingManager(Employee employee)
    {
        this.employee = employee;
    }

    public void SetRequiredFee(Fee requiredFee)
    {
        for (Apartment apartment : apartments)
        {
            apartment.SetPaymentFee(requiredFee);
        }
    }

    public String GetBuildingAddress()
    {
       return address;
    }

    public Material GetBuildingMaterial()
    {
        return material;
    }

    public int GetBuildingAge()
    {
        return builtYear;
    }

    public double GetBuildingTotalArea()
    {
       return totalArea;
    }

    public double GetBuildingArea()
    {
       return livingArea;
    }

    public double GetMutualArea()
    {
        return mutualArea;
    }

    public int GetFloorsAmount()
    {
        return floorsAmount;
    }

    public int GetApartmentsAmount()
    {
        return apartments.size();
    }

    public Employee GetBuildingManager(Employee employee)
    {
         return employee;
    }

    public List<Apartment> GetApartmentsList()
    {
        return apartments;
    }

    public int GetBuildingResidentsAmount()
    {
        buildingResidentsAmount = 0;
        for(Apartment apartment : apartments)
        {
            buildingResidentsAmount += apartment.GetResidentsAmount();
        }
        return buildingResidentsAmount;
    }

    public void AddApartments(HashSet<Apartment> apartments)
    {
       this.apartments.addAll(apartments);
    }

    public void AddApartment(Apartment apartment)
    {
        this.apartments.add(apartment);
    }

    public void ShowOwnersList()
    {
        apartments.forEach((apartment -> System.out.println(apartment + "\r")));
    }

    @Override
    public String toString()
    {
        return ("Address: " +  address + "\n" +
                "Built material: " + material + "\n" +
                "Built year: " + builtYear + "\n" +
                "Total area: " + totalArea + "\n" +
                "Build-up area: " + livingArea + "\n" +
                "Mutual area: " + mutualArea + "\n" +
                "Floors: " + floorsAmount + "\n" +
                "Amount of apartments: " + apartmentsAmount + "\n");
    }
}
