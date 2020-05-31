import java.util.*;

public class HomeManager
{
   Company company;
   private double compulsoryFee;
   private double feePerResident;
   private Employee employeeManager;
   private Fee calculatedApartmentFee;
   private double requiredBuildingFee;
   private double collectedFees;
   private int residentsAmount;

   Building building;

   private HashSet<Building> managedBuildings;
   private HashSet<Employee> employeesHomeManagers;
   private List<Apartment> buildingApartments;
   protected HashMap<Apartment, Boolean> apartmentsPaymentStatus;

   HomeManager()
   {
      this.company = new Company();
      this.compulsoryFee = 0.0;
      this.feePerResident = 0.0;
      requiredBuildingFee = 0.0;
      collectedFees = 0;
      managedBuildings = new HashSet<Building>();
      employeesHomeManagers = new HashSet<Employee>();
      buildingApartments = new ArrayList<>();
      apartmentsPaymentStatus = new HashMap<Apartment, Boolean>();
   }

   HomeManager(Company company, double compulsoryFee, double feePerResident)
   {
      this.company = company;
      this.compulsoryFee = compulsoryFee;
      this.feePerResident = feePerResident;
      requiredBuildingFee = 0.0;
      collectedFees = 0;
      managedBuildings = new HashSet<Building>();
      employeesHomeManagers = new HashSet<Employee>();
      buildingApartments = new ArrayList<>();
      apartmentsPaymentStatus = new HashMap<Apartment, Boolean>();
   }

   public void SetManagementCompany(Company company)
   {
      this.company = company;
   }

   public void SetCompulsoryFee(double compulsoryFee)
   {
      this.compulsoryFee = compulsoryFee;
   }

   public void SetResidentFee(double feePerResident)
   {
      this.feePerResident = feePerResident;
   }

   public void SetManagedBuilding(Building building)
   {
      this.building = building;
      managedBuildings.add(building);
      buildingApartments = building.GetApartmentsList();
      residentsAmount = building.GetBuildingResidentsAmount();
   }

   public String SetHomeManager() throws MaxBuildingsAmountException
   {
      for (Employee employee : employeesHomeManagers)
      {
         int buildingsAmount = employee.GetEmployeeBuildingsList().size();
         int maxBuildingsAmount = employee.GetMaxBuildingsAmount();

         if (buildingsAmount == 0 || buildingsAmount < maxBuildingsAmount)
         {
            employee.AddToBuildingsList(building);
            building.SetBuildingManager(employee);
            return ("\rThis building is going to be managed by:\r" + employee);
         }
      }
      throw new MaxBuildingsAmountException("Each employee has reached maximum amount of managed buildings");
   }

   public String SetHomeManager(String employeeName) throws MaxBuildingsAmountException
   {
       Employee employee = employeesHomeManagers.stream()
                                                .filter(e -> e.GetPersonName().equals(employeeName))
                                                .findAny()
                                                .orElse(null);
       if(employee != null)
       {
          int buildingsAmount = employee.GetEmployeeBuildingsList().size();
          int maxBuildingsAmount = employee.GetMaxBuildingsAmount();

          if (buildingsAmount == 0 || buildingsAmount < maxBuildingsAmount) {
             employee.AddToBuildingsList(building);
             building.SetBuildingManager(employee);
             return ("This building is going to be managed by:" + employee);
          }
       }
       throw new MaxBuildingsAmountException("Each employee has reached maximum amount of managed buildings");
   }

   public void SetFloorFeeIncrement(int floorLimitIncrement, double lowerLimitFee, double upperLimitFee)
   {
      int residentsAmount = building.GetBuildingResidentsAmount();
      int floors = building.GetFloorsAmount();

      if(floors <= floorLimitIncrement)
         compulsoryFee += lowerLimitFee;
      else
         compulsoryFee += upperLimitFee;
   }

   public void SetResidentFeeIncrement(int lowerLimitResidents, double lowerLimitIncrement,
                                       int upperLimitResidents, double upperLimitIncrement,
                                       double highestIncrement)
   {
      if(residentsAmount <= lowerLimitResidents)
         feePerResident += lowerLimitIncrement;
      else if(residentsAmount < upperLimitResidents)
         feePerResident += upperLimitIncrement;
      else
         feePerResident += highestIncrement;
   }

   public void SetCalculatedApartmentFee()
   {
      calculatedApartmentFee = new Fee(compulsoryFee, feePerResident);
      building.SetRequiredFee(calculatedApartmentFee);
   }

   public void SetPaymentStatus()
   {
      for (Apartment apartment :  buildingApartments)
      {
         boolean status = apartment.GetPaymentAgreement();
         if(status)
            SetStatus(apartment, true);
         else
            SetStatus(apartment, false);
      }
   }

   private void SetStatus (Apartment apartment, boolean status)
   {
      if(!apartmentsPaymentStatus.containsKey(apartment))
         apartmentsPaymentStatus.put(apartment, status);
      else
         apartmentsPaymentStatus.replace(apartment, apartmentsPaymentStatus.get(apartment), status);
   }

   public Company GetManagingCompany()
   {
      return company;
   }

   public double GetBasicFee()
   {
      return compulsoryFee;
   }

   public double GetResidentFee()
   {
      return feePerResident;
   }

   public double GetFloorFeeIncrement()
   {
      return compulsoryFee;
   }

   public double GetResidentFeeIncrement()
   {
      return feePerResident;
   }

   public Fee GetCalculatedApartmentFee()
   {
      return calculatedApartmentFee;
   }

   public double GetCollectedFees()
   {
      collectedFees = 0.0;
      for (Apartment apartment :  buildingApartments)
      {
         collectedFees += apartment.GetApartmentFee();
      }
      return collectedFees;
   }

   public int GetManagedBuildingsAmount()
   {
      return managedBuildings.size();
   }

   public void AddHomeManagersList(HashSet<Employee> employees)
   {
      employeesHomeManagers.addAll(employees);
   }

   public void AddHomeManagerToList(Employee employee)
   {
      employeesHomeManagers.add(employee);
   }

   public void AddBuildingToList(Building building)
   {
      managedBuildings.add(building);
   }

   public double ShowRequiredFee()
   {
      requiredBuildingFee = 0.0;

      for (Apartment apartment :  buildingApartments)
      {
         requiredBuildingFee += calculatedApartmentFee.GetCompulsoryFee() +
                             calculatedApartmentFee.GetResidentFee() * apartment.GetResidentsAmount();
      }

      return requiredBuildingFee;
   }

   public void ShowManagedBuildings()
   {
      managedBuildings.forEach(System.out::println);
   }

   public void ShowPaymentStatus()
   {
      apartmentsPaymentStatus.forEach((apartment, status) ->
              System.out.println("Apartment: " + apartment.GetApartmentNumber() +
                      " " + "Fee: " + apartment.GetApartmentFee() + " " +
                      "Status: " + ((status) ? "paid" : "unpaid")));

   }

   public int ShowResidentsAmount()
   {
      return building.GetBuildingResidentsAmount();
   }

   public int ShowApartmentsAmount()
   {
      return building.GetApartmentsAmount();
   }
}
