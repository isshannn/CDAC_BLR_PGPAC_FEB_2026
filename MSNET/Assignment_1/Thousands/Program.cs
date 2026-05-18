namespace Thousands
{
    internal class Program
    {
        static void Main(string[] args)
        {
            System.Console.WriteLine("Enter an integer");
            int number = int.Parse(System.Console.ReadLine());
            int remainder = number % 1000;
            int nearThou = (int)Math.Round(number / 1000.0, MidpointRounding.AwayFromZero) * 1000;
            System.Console.WriteLine("Nearest Thosands: " + nearThou);
        }
    }
}