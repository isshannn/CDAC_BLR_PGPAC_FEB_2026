namespace TypeConversion
{
    internal class Program
    {
        public static void Main()
        {
            // 1. Implicit Conversion (Safe, no data loss)
            int myInt = 100;
            double myDouble = myInt;

            // 2. Explicit Casting (Potential data loss)
            double pi = 3.14;
            int roundedPi = (int)pi;

            // 3. String to Numeric (Parsing)
            string scoreText = "450";
            int score = int.Parse(scoreText);

            // 4. Numeric to String
            string displayScore = score.ToString();

            // 5. Convert Class (Handles nulls and various types)
            string val = "true";
            bool isActive = Convert.ToBoolean(val);

            // 6. Safe Parsing (Prevents runtime crashes)
            string input = "abc";
            bool success = int.TryParse(input, out int result);

            Console.WriteLine($"Double: {myDouble}, Int: {roundedPi}, Bool: {isActive}, Success: {success}");
        }
    };
}