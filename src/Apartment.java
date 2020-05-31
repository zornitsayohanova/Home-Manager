

public class Apartment
{
    private Owner owner;
    private String number;
    private int floor;
    private int residentsAmount;
    private boolean agreementStatus;
    private double thisApartmentFee;
    private Fee calculatedApartmentFee;

    Apartment()
    {
        owner = new Owner();
        number = "";
        floor = 0;
        residentsAmount = 0;
        agreementStatus = false;
        thisApartmentFee = 0.0;
    }

    Apartment(Owner owner, String number, int floor, int residentsAmount, boolean agreementStatus)
    {
        this.owner = owner;
        this.number = number;
        this.floor = floor;
        this.residentsAmount = residentsAmount;
        this.agreementStatus = agreementStatus;
        thisApartmentFee = 0.0;
    }

    public void SetApartmentOwner(Owner owner)
    {
        this.owner = owner;
    }

    public void SetApartmentNumber(String number)
    {
        this.number = number;
    }

    public void SetApartmentFloor(int floor)
    {
        this.floor = floor;
    }

    public void SetResidentsAmount(int residentsAmount)
    {
        this.residentsAmount = residentsAmount;
    }

    public void SetPaymentAgreement(boolean agreementStatus)
    {
       this.agreementStatus = agreementStatus;
    }

    public void SetPaymentFee(Fee calculatedApartmentFee)
    {
        this.calculatedApartmentFee = calculatedApartmentFee;
        PayFee();
    }

    private void PayFee()
    {
        if (agreementStatus)
        {
            thisApartmentFee = calculatedApartmentFee.GetCompulsoryFee() + calculatedApartmentFee.GetResidentFee() * residentsAmount;
            agreementStatus = true;
        }
    }

    public Owner GetApartmentOwner()
    {
        return owner;
    }

    public String GetApartmentNumber()
    {
        return number;
    }

    public int GetApartmentFloor()
    {
        return floor;
    }

    public int GetResidentsAmount()
    {
        return residentsAmount;
    }

    public boolean GetPaymentAgreement()
    {
        return agreementStatus;
    }

    public double GetApartmentFee()
    {
        return thisApartmentFee;
    }

    @Override
    public String toString()
    {
        return ("\r -- Owner " +  owner + "\n" +
                "Number: " + number + "\n" +
                "Floor: " + floor + "\n" +
                "Amount of residents: " + residentsAmount + "\n" +
                "Current payment agreement: " + ((agreementStatus) ? "agree" : "disagree") + "\n" +
                "Current fee to pay: " + thisApartmentFee + "\n");
    }
}
