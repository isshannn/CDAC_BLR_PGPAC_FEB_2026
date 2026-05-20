namespace Medical_Bob
{
    public class Patient
    {
        string name;
        int symptom;

        public Patient(string Pname , int Psymp)
        {
            this.name = Pname;
            this.symptom = Psymp;
        }

        public void Consult()
        {
            switch (symptom)
            {
                case 1: System.Console.WriteLine("Medicine A");
                    break;
                case 2: System.Console.WriteLine("Medicine B");
                    break;
                case 3: System.Console.WriteLine("Medicine C");
                    break;
            }
        }
    };
    internal class Program
    {
        public static void Main(string[] args)
        {
            System.Console.WriteLine("Enter Patient Name and Symptom");
            string Name; 
            int Symptom=0;
            Name = Console.ReadLine();
            System.Console.WriteLine("Choose Symptom");
            System.Console.WriteLine("1: Sickness");
            System.Console.WriteLine("2: Diziness");
            System.Console.WriteLine("3: Nausea");
            int ch = int.Parse(System.Console.ReadLine());
            switch (ch)
            {
                case 1: Symptom = 1;
                        break;
                case 2: Symptom = 2;
                        break;
                case 3: Symptom = 3;
                        break;
                default: System.Console.WriteLine("Invalid Entry. Exiting...");
                         Environment.Exit(1);
                         break;
            }
            Patient p1 = new Patient(Name,Symptom);
            p1.Consult();
        }
    };
}