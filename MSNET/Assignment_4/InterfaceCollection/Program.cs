namespace InterfaceCollection
{
    internal class Program
    {
        public interface IPaymentMethod
        {
            string Name { get; }
            void ProcessPayment(decimal amount);
        }
        public class CreditCard(string cardNumber) : IPaymentMethod
        {
            public string Name => "Credit Card";
            public void ProcessPayment(decimal amount) =>
                Console.WriteLine($"Charging ${amount} to Card ending in {cardNumber[^4..]}. (Authorized)");
        }

        public class PayPal(string email) : IPaymentMethod
        {
            public string Name => "PayPal";
            public void ProcessPayment(decimal amount) =>
                Console.WriteLine($"Redirecting {email} to PayPal gateway for ${amount}.");
        }

        public class Crypto(string walletAddress) : IPaymentMethod
        {
            public string Name => "Bitcoin";
            public void ProcessPayment(decimal amount) =>
                Console.WriteLine($"Verifying blockchain transaction of ${amount} to {walletAddress[..8]}...");
        }
        public static void Main(string[] args)
        {
            List<IPaymentMethod> availableMethods = new()
            {
                new CreditCard("1234567812345678"),
                new PayPal("user@example.com"),
                new Crypto("1BoatSLRHtKNngkd3Nv9898")
            };

            decimal totalToPay = 99.50m;

            Console.WriteLine($"--- Checkout: Total {totalToPay:C} ---");

            // Iterate through the collection
            foreach (var method in availableMethods)
            {
                Console.WriteLine($"\n[Attempting {method.Name}]");
                method.ProcessPayment(totalToPay);
            }
        }
    }
}