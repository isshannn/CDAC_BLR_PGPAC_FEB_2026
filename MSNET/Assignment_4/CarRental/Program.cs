namespace CarRental
{
    internal class Program
    {
        public class Car(string make, string model, decimal price)
        {
            public Guid Id { get; } = Guid.NewGuid();
            public string Make { get; } = make;
            public string Model { get; } = model;
            public decimal DailyPrice { get; } = price;
            public bool IsAvailable { get; set; } = true;
            public override string ToString() =>
                $"{Make} {Model} (Rs. {DailyPrice}/day) - {(IsAvailable ? "Available" : "Rented")}";
        }
        public class RentalAgency
        {
            private readonly List<Car> _inventory = new();
            public void AddCar(Car car) => _inventory.Add(car);

            public IEnumerable<Car> GetAvailableCars() =>
                _inventory.Where(c => c.IsAvailable);

            public bool RentCar(string make)
            {
                var car = _inventory.FirstOrDefault(c =>
                    c.Make.Equals(make, StringComparison.OrdinalIgnoreCase) && c.IsAvailable);

                if (car == null) return false;

                car.IsAvailable = false;
                return true;
            }
        }
        public static void Main(string[] args)
        {
            var agency = new RentalAgency();

            // Seed data
            agency.AddCar(new Car("Tesla", "Model 3", 75.00m));
            agency.AddCar(new Car("Toyota", "Camry", 45.00m));
            agency.AddCar(new Car("Ford", "F-150", 60.00m));

            Console.WriteLine("--- Welcome to CDAC Rentals ---");

            while (true)
            {
                Console.WriteLine("\nAvailable Cars:");
                var available = agency.GetAvailableCars().ToList();

                if (!available.Any())
                {
                    Console.WriteLine("Sorry, we are fully booked!");
                    break;
                }

                foreach (var car in available) Console.WriteLine($"- {car}");

                Console.Write("\nEnter the MAKE of the car you want to rent (or 'exit'): ");
                string input = Console.ReadLine() ?? "";

                if (input.ToLower() == "exit") break;

                if (agency.RentCar(input))
                {
                    Console.WriteLine($"Success! You have rented a {input}.");
                }
                else
                {
                    Console.WriteLine("Sorry, that car is not available or doesn't exist.");
                }
            }
        }
    }
}