import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Please, enter you company name: ");
        String companyName = myObj.nextLine();
        System.out.println("Please, enter you name: ");
        String companyOwner = myObj.nextLine();

        Company companyV = new Company(companyName, companyOwner);

        Employee first = new Employee("Velislava Doncheva", 28, "Bulgarian", Person.Gender.FEMALE, "12321");
        Employee second = new Employee("Manuel Vekilov", 30, "Bulgarian", Person.Gender.MALE, "32456");
        Employee third = new Employee("Lachezar Hristov", 34, "Bulgarian", Person.Gender.MALE, "68905");
        Employee fourth = new Employee("Ani Yurukova", 39, "Bulgarian", Person.Gender.FEMALE, "90995");
        Employee fifth = new Employee("Marieta Dimova", 30, "Bulgarian", Person.Gender.FEMALE, "76545");

        System.out.println("Please, the maximum amount of buildings, each employee should manage: ");
        int maxAmount= myObj.nextInt();

        HashSet<Employee> employees = new HashSet<Employee>();
        Collections.addAll(employees, first, second, third, fourth, fifth);
        employees.forEach(employee -> employee.SetMaxBuildingsAmount(maxAmount));
        companyV.AddEmployees(employees);
        System.out.println("\r");
        System.out.println(" ----- Company \"" + companyV.GetCompanyName() + "\" list of employees: ");
        companyV.ShowAllEmployees();

        Owner firstO = new Owner("Ivan Petrov", 29, "Bulgarian", "architect", Person.Gender.MALE);
        Owner secondO = new Owner("John Hudgens", 22, "American", "singer", Person.Gender.MALE);
        Owner thirdO = new Owner("Gertrude Hanz", 55, "German", "accountant", Person.Gender.FEMALE);
        Owner fourthO = new Owner("Alma Hernandez", 19, "Spanish", "dancer", Person.Gender.FEMALE);
        Owner fifthO = new Owner("Stefan Marinov", 45, "Bulgarian", "programmer", Person.Gender.MALE);
        Owner sixthO = new Owner("Magdalena Ivanova", 35, "Bulgarian", "nurse", Person.Gender.FEMALE);

        Apartment firstA = new Apartment(firstO, "1A", 1, 3, false);
        Apartment fifthA = new Apartment(secondO, "5A", 5, 2, true);
        Apartment thirdC = new Apartment(thirdO, "3C", 3, 1, false);
        Apartment fourB = new Apartment(fourthO, "4B", 4, 4, true);
        Apartment secondC = new Apartment(fifthO, "2C", 2, 2, true);
        Apartment firstB = new Apartment(sixthO, "1B", 1, 3, true);

        HashSet<Apartment> apartments = new HashSet<Apartment>();
        Collections.addAll(apartments, firstA, fifthA, thirdC, fourB, secondC, firstB);

        Building building = new Building("Sofia 1000, Andrey Liapchev 5 - Mladost borough", Building.Material.CONCRETE, 1998, 120.4, 100.6, 20.4, 5, 15);
        building.AddApartments(apartments);

        System.out.println("\r");
        System.out.println(" ----- Owners of building with address \"" + building.GetBuildingAddress() + "\"" + "\r");
        building.ShowOwnersList();

        System.out.println("Please, enter the compulsory fee per apartment: ");
        double compulsoryFee = myObj.nextDouble();
        System.out.println("Please, enter the fee per resident: ");
        double residentFee = myObj.nextDouble();

        HomeManager companyManager = new HomeManager(companyV, compulsoryFee, residentFee);
        companyManager.AddHomeManagersList(employees);
        companyManager.SetManagedBuilding(building);

        System.out.println("Please, enter the floor, serving as criteria for fee increment: ");
        int criteriaFloor = myObj.nextInt();
        System.out.println("Please, enter the fee increment (for buildings, having 1-" + criteriaFloor + " floors): ");
        double lowerLimitFee = myObj.nextDouble();
        System.out.println("Please, enter the fee increment (for buildings, having more than " + criteriaFloor + " floors): ");
        double upperLimitFee = myObj.nextDouble();

        companyManager.SetFloorFeeIncrement(criteriaFloor, lowerLimitFee, upperLimitFee);

        System.out.println("Please, enter the first amount of residents, serving as criteria for fee increment: ");
        int lowerLimitResidents = myObj.nextInt();
        System.out.println("Please, enter the fee increment (for buildings, having 1-" + lowerLimitResidents + " residents): ");
        double lowerLimitIncrement = myObj.nextDouble();
        System.out.println("Please, enter the second amount of residents, serving as criteria for fee increment: ");
        int upperLimitResidents = myObj.nextInt();
        System.out.println("Please, enter the fee increment (for buildings, having " + lowerLimitResidents + "-" +
                                                             upperLimitResidents + " residents): ");
        double upperLimitIncrement = myObj.nextDouble();
        System.out.println("Please, enter the fee increment (for buildings, having more than " +
                                                            upperLimitResidents + " residents)");
        double highestIncrement = myObj.nextInt();
        companyManager.SetResidentFeeIncrement(lowerLimitResidents, lowerLimitIncrement,
                                               upperLimitResidents, upperLimitIncrement,
                                               highestIncrement);
        System.out.println("\r");
        try
        {
            System.out.println(companyManager.SetHomeManager());
        }
        catch (MaxBuildingsAmountException e)
        {
            System.out.println(e);
        }
        System.out.println("\r");

        companyManager.SetCalculatedApartmentFee();
        System.out.println("------- Calculated service fee per apartment: ");
        System.out.println(companyManager.GetCalculatedApartmentFee());

        System.out.println("------- Required total service fee: ");
        System.out.println(companyManager.ShowRequiredFee());

        System.out.println("------- Collected apartments fees: ");
        System.out.println(companyManager.GetCollectedFees());
        System.out.println("\r");

        System.out.println("------- Status of fees (per apartment): ");
        companyManager.SetPaymentStatus();
        companyManager.ShowPaymentStatus();
        System.out.println("\r");

        System.out.println("------- Apartments amount: ");
        System.out.println(companyManager.ShowApartmentsAmount());
        System.out.println("\r");

        System.out.println("------- Sum of all residents in the building: ");
        System.out.println(companyManager.ShowResidentsAmount());
        System.out.println("\r");

        System.out.println("------- Amount of managed buildings: ");
        System.out.println(companyManager.GetManagedBuildingsAmount());
        System.out.println("\r");

        System.out.println("-------- Company \"" + companyName + "\" managed buildings: ");
        System.out.println("\r");
        companyManager.ShowManagedBuildings();
        System.out.println("\r");


        Building Borovo = new Building("Priroda 7", Building.Material.PANEL, 1990, 150.9, 120.6, 13.6, 11, 33);
    }
}


      /*  int k = 0, j = 1, p = 0;

        for (int i = 0; i < 5; i++) {
            k = ++j;
            System.out.println(k);
            p = k + j++;
            System.out.println(p);
        }
*/