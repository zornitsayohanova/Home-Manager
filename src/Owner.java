public class Owner extends Person
{
    private String ownerProfession;

    public Owner()
    {
        super();
        ownerProfession = "unknown";
    }

    public Owner(String ownerName, int ownerAge, String ownerNationality,
                 String ownerProfession, Gender ownerGender)
    {
        super(ownerName, ownerAge, ownerNationality, ownerGender);
        this.ownerProfession = ownerProfession;
    }

    public void SetPersonName(String ownerName)
    {
        this.personName = ownerName;
    }

    public void SetPersonAge(int ownerAge)
    {
        personAge = ownerAge;
    }

    public void SetPersonNationality(String ownerNationality)
    {
        personNationality = ownerNationality;
    }

    public void SetPersonGender(Gender ownerGender)
    {
        personGender = ownerGender;
    }

    public void SetPersonProfession(String ownerProfession)
    {
        this.ownerProfession = ownerProfession;
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

    public String GetPersonProfession()
    {
        return ownerProfession;
    }

    @Override
    public String toString()
    {
        return super.toString() + ("Profession: " + ownerProfession);
    }
}
