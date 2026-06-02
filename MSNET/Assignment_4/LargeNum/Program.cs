using System.Numerics;

namespace LargeNum
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            List<int> integers = [10, 45, 99, 23];
            double[] doubles = [12.5, 88.2, 7.1, 99.9];
            HashSet<decimal> decimals = [150.50m, 300.25m, 10.00m];

            // 2. Call the method for each
            Console.WriteLine($"Max Integer: {FindMax(integers)}");
            Console.WriteLine($"Max Double:  {FindMax(doubles)}");
            Console.WriteLine($"Max Decimal: {FindMax(decimals)}");

            /// <summary>
            /// Finds the largest number in any collection of numbers.
            /// </summary>
            /// <typeparam name="T">A type that implements INumber (int, double, decimal, etc.)</typeparam>
            static T FindMax<T>(IEnumerable<T> collection) where T : INumber<T>
            {
                if (collection == null || !collection.Any())
                    throw new ArgumentException("Collection cannot be null or empty.");

                // Uses LINQ's Max() which is highly optimized in .NET
                return collection.Max()!;
            }
        }
    }
}