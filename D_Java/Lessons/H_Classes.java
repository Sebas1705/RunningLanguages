import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class H_Classes {

    public static void main(String[] args) {

        Person p=new Worker("Pedro","Mendoza",LocalDateTime.of(2000,12,12,10,53),"Construction",TypeWorker.SUBCONTRACT);
        p.doYourLife();
    
    }
    
    //abstract class (normal class but not completely implemented)
    static abstract class Person{

        //Properties:
        private final String dni;
        private final LocalDateTime birthDate;
        protected String name; //protected just is for inheritance;

        //Static properties:
        private static int dni_number_gen=47469286;
        private static final String charsOfDni="TRWAGMYFPDXBNJZSQVHLCKE";
        
        private static String dni_generator(){
            int number=dni_number_gen++;
            return String.format("%08d",number)+charsOfDni.charAt(number%23);
        } 

        //Getters:
        public LocalDateTime getBirthDate(){return this.birthDate;}
        public String getName(){return this.name;}
        public String getDni(){return this.dni;}

        //Setters:
        public void setName(String name){this.name=name;}

        //Constructor:

        public Person(String firstName,String lastName){
            this.name=firstName+lastName;
            this.birthDate=LocalDateTime.now();
            this.dni=dni_generator();
        }
        public Person(String firstName,String lastName,LocalDateTime birthDate){
            this.name=firstName+lastName;
            this.birthDate=birthDate;
            this.dni=dni_generator();
        }

        //Methods:
        public double getAge(){
            LocalDateTime now = LocalDateTime.now();
            return Duration.between(birthDate,now).toDays()/365;
        }
        
        public abstract void doYourLife();
    }

    //inheritance:
    static class Student extends Person{

        private String[] subjects;
        private String center,grade;

        public Student(String name,String lastName,LocalDateTime birthDate,String center,String grade,String...subjects){
            super(name,lastName,birthDate);
            this.subjects=subjects;
            this.center=center;
            this.grade=grade;
        }

        public String[] getSubjects(){return this.subjects;}
        public String center(){return this.center;}
        public String grade(){return this.grade;}

        public void setSubjects(String[] subjects){this.subjects=subjects;}
        public void setCenter(String center){this.center=center;}
        public void setGrade(String grade){this.grade=grade;}

        @Override
        public void doYourLife() {
            System.out.println("Studying...");
            System.out.println("Eating...");
            System.out.println("Sleeping...");
        }
    }

    //interfaces (only functions to be implemented):
    static interface Workable{
        public void work();
    }

    //Enum:
    static enum TypeWorker{INDEPENDENT,SUBCONTRACT,FREELANCE}

    static class Worker extends Person implements Workable{ //one inherited and multiple implements

        private String work;
        private TypeWorker typeWorker;

        public Worker(String name,String lastName,LocalDateTime birthDate,String work,TypeWorker typeWorker){
            super(name,lastName,birthDate);
            this.work = work;
            this.typeWorker=typeWorker;
        }

        @Override
        public void work() {
            System.out.println("Working in "+work+" as "+typeWorker.name());
        }

        @Override
        public void doYourLife() {
            System.out.println("Eating...");
            work();
            System.out.println("Sleeping...");
        }

        
    }

    //Generic class:
    @SuppressWarnings("unchecked")
    static class Array <T extends Number> {
        
        public T[] array;

        public Array(T...elements){this.array=elements;}
        public Array(List<? extends T> elements){this.array=(T[])elements.toArray();}
    }
}
