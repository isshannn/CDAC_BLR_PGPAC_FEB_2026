namespace TimeUnit
{
    internal class Program
    {
        public static void Main(string[] args)
        {

            System.Console.WriteLine("Enter total seconds");

            long totalSeconds = long.Parse(System.Console.ReadLine());

            // Define time constants in seconds
            long secondsInMinute = 60;
            long secondsInHour = 60 * secondsInMinute;      // 3,600
            long secondsInDay = 24 * secondsInHour;         // 86,400
            long secondsInYear = 365 * secondsInDay;        // 31,536,000

            // Calculate Years
            long years = totalSeconds / secondsInYear;
            long remainingSeconds = totalSeconds % secondsInYear;

            // Calculate Days
            long days = remainingSeconds / secondsInDay;
            remainingSeconds %= secondsInDay;

            // Calculate Hours
            long hours = remainingSeconds / secondsInHour;
            remainingSeconds %= secondsInHour;

            // Calculate Minutes and Seconds
            long minutes = remainingSeconds / secondsInMinute;
            long seconds = remainingSeconds % secondsInMinute;

            // Display the results
            Console.WriteLine($"Total Seconds: {totalSeconds}\n");
            Console.WriteLine($"{years} Years");
            Console.WriteLine($"{days} Days");
            Console.WriteLine($"{hours} Hours");
            Console.WriteLine($"{minutes} Minutes");
            Console.WriteLine($"{seconds} Seconds");
        }
    }
}
