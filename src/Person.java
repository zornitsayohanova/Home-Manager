abstract class Person
{
    protected String personName;
    protected int personAge;
    protected String personNationality;

    protected enum Gender
    {
        MALE, FEMALE, UNSET
    }

    Gender personGender;

    public Person()
    {
        this.personName = "";
        this.personAge = 0;
        this.personNationality = "";
        this.personGender = Gender.UNSET;
    }

    public Person(String personName, int personAge, String personNationality, Gender personGender)
    {
        this.personName = personName;
        this.personAge = personAge;
        this.personNationality = personNationality;
        this.personGender = personGender;
    }

    public abstract void SetPersonName(String ownerName);

    public abstract void SetPersonAge(int ownerAge);

    public abstract void SetPersonNationality(String ownerNationality);

    public abstract void SetPersonGender(Owner.Gender ownerGender);

    public abstract String GetPersonName();

    public abstract int GetPersonAge();

    public abstract Gender GetPersonGender();

    public abstract String GetPersonNationality();

    @Override
    public String toString()
    {
        return ("\r\nName: " + personName + "\n" +
                "Age: " + personAge + "\n" +
                "Nationality: " + personNationality + "\n" +
                "Gender: " + personGender + "\n");
    }
}
