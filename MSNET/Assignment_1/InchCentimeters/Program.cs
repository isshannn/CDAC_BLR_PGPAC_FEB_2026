namespace InchCentimeters
{
    internal class Program
{
    static void Main(string[] args)
    {
            System.Console.WriteLine("Enter Height in Inches");
            float HIn= float.Parse(System.Console.ReadLine());
            double HCm = HIn * 2.54;
            System.Console.WriteLine("Height in Centimeters: " + HCm);
            if (HCm < 160)
                System.Console.WriteLine("Short Height Category");
            else if (HCm < 178)
                System.Console.WriteLine("Average Height Category");
            else
                System.Console.WriteLine("Tall Height Category");
    }
}
}