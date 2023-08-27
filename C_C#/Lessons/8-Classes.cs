using static System.Console;

namespace Lessons
{
    public class Classes
    {
        public static void ExMain(string[] args)
        {
            Human human= new Human("Pedro",19);
            WriteLine(human.ToString());
            Human human2= new Student("We",19);
            WriteLine(human2.ToString());

            Vehicle v=new Car(Models.Mustang);
            v.Go();

            List<Human> children=new List<Human>(human,human2);
            children.Print();WriteLine();

            Worker w=new Worker(100.00);
            Worker w2=w;
            w.ChangeSalary(1000);
            WriteLine(w.salary);
            WriteLine(w2.salary);
        }
    }

    public class Human{

        //Attributes:
        private static uint staticId=1;
        private readonly string id;
        protected int age;
        protected string name;

        //Getters:
        public int GetAge(){return this.age;}
        public string GetName(){return this.name;}

        //Setters:
        public void SetName(string name){this.name = name;}
        public void SetAge(int age){this.age = age;}

        //Constructor:
        public Human(string name,int age){
            this.id=$"{name.Substring(0,1)}{staticId.ToString(),-3}";
            staticId++;
            this.age = age;
            this.name = name;
        }

        //Methods:
        public override string ToString() {return MakeStringOfHuman(this);}
        public static string MakeStringOfHuman(Human human){return $"{human.name}:{human.age}:{human.id}";}
    }

    public class Student : Human{
        public Student(string name, int age) : base(name, age){
            if(age>=30) WriteLine("Too old");
        }
    }

    public interface ICar{
        public void printCar();
    }

    public abstract class Vehicle{
        protected uint nWheels;
        public Vehicle(uint nWheels){
            this.nWheels = nWheels;
        }
        public abstract void Go();
        public virtual void Print(){
            WriteLine($"{this.nWheels}");
        }
    }

    public class Car : Vehicle, ICar{
        private readonly Models model;
        public Car(Models model) : base(4){
            this.model = model;
        }
        public override void Go() {
            WriteLine($"Going car({this.model})");
        }

        public override void Print(){
            WriteLine($"{this.model} with {this.nWheels}");
        }

        public void printCar()
        {
            throw new NotImplementedException();
        }
    }

    public enum Models{
        Mustang=1,Mercedes,Ford,Ferrari,Lamborghini
    }

    public sealed class List <T> where T : Human{ //Not derivable (sealed) and T have to derivable from vehicle
        public T[] Array { get{return this._array;} set{this._array = value.ToArray();} }
        private T[] _array;

        public List(params T[] array) {
            this.Array = array;
        }
        public void Print(){
            foreach(T item in this.Array){Write($"{((item==null)?"NULL":item.ToString())} ");}
        }

        ~List(){
            //Close readers, etc...
        }
    }

    public struct Worker{ //Struct not have references as objects
        public double salary;

        public Worker(double salary=0){
            this.salary = salary;
        }

        public void ChangeSalary(double increment){
            this.salary+=increment;
        }
    }
}