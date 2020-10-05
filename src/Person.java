import java.util.Scanner;

public class Person {
    private String newName;

    public Person(String name) {
        this.newName = name;
    }

    public String getName(){
//TODO: return the person's name
        return this.newName;
    }

    public void setName(String name){
//TODO: change the name property to the passed value
        this.newName = name;
    }
    public void sayHello(){
//TODO: print a message to the console using the person's name
        System.out.print(this.newName+" says Hello!");
    }

    public static void main(String[] args) {
        Person someone = new Person("Mack");
        System.out.println(someone.getName());
        someone.setName("George");
        someone.sayHello();
        System.out.println(someone.getName());
        Person person1 = new Person("John");
        Person person2 = person1;
        System.out.println(person1.getName());
        System.out.println(person2.getName());
        person2.setName("Jane");
        System.out.println(person1.getName());
        System.out.println(person2.getName());
    }
}
