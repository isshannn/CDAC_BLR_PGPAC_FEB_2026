namespace CircleArea
{
    internal class Program
{
    static void Main(string[] args)
    {

            System.Console.WriteLine("Enter Radius of the Circle");
            float r;
            r = float.Parse(System.Console.ReadLine());
            System.Console.WriteLine("Area of Circle =" + 3.14 * r * r);
    }
}
}