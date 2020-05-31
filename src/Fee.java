

public class Fee
{
   private double compulsoryFee;
   private double feePerResident;

   Fee()
   {
      this.compulsoryFee = 0.0;
      this.feePerResident = 0.0;
   }

   Fee(double compulsoryFee, double feePerResident)
   {
      this.compulsoryFee = compulsoryFee;
      this.feePerResident = feePerResident;
   }

   public void SetCompulsoryFee(double compulsoryFee)
   {
      this.compulsoryFee = compulsoryFee;
   }

   public void SetResidentFee(double feePerResident)
   {
     this.feePerResident = feePerResident;
   }

   public double GetCompulsoryFee()
   {
       return compulsoryFee;
   }

   public double GetResidentFee()
   {
       return feePerResident;
   }

   @Override
   public String toString()
   {
      return  "Compulsory apartment fee: " + compulsoryFee + "\r\n" +
              "Fee per resident: " + feePerResident + "\r\n";
   }
}
