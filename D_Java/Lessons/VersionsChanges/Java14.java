package VersionsChanges;
public class Java14 {
    

    public static void main(String[] args) {
        
        ///Records(constant object auto-implemented)\\\
        Person person = new Person("Sebas",21);
        System.out.println(person);

        ///Patterns instanceof\\\
        Object obj = "Hello, Java 14!";
        if (obj instanceof String str && str.length() > 10) {
            System.out.println("Long string: " + str);
        }
    }

    public record Person(String name,int age){
        public void doSomething(){System.out.println("Something");}
    }
}
