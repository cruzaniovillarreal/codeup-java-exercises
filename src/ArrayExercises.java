import java.util.Arrays;

public class ArrayExercises {

    public static void addPerson(Person[] arrayOfPersons, Person personToAdd) {
        Person[] copyToReturn = Arrays.copyOf(arrayOfPersons, arrayOfPersons.length+1);
        copyToReturn[copyToReturn.length-1] = personToAdd;
//        copyToReturn[arrayOfPersons.length] = personToAdd;
        for (Person newPerson: copyToReturn) {
            System.out.println(newPerson.getName());
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(numbers));

        //Different ways to initialize an array.
        Person[] listOfPeople = new Person[3];
        listOfPeople[0] = new Person("Mike");
        listOfPeople[1] = new Person("John");
        listOfPeople[2] = new Person("Rango");
        Person newGuy = new Person("Fred");
        addPerson(listOfPeople, newGuy);
        // OR

        Person[] newListOfPeople = {
                new Person("Mike"),
                new Person("John"),
                new Person("Rango")
        };

        for (Person newPerson: listOfPeople) {
            System.out.println(newPerson.getName());
        }
//        for (Person newPerson: newListOfPeople) {
//            System.out.println(newPerson.getName());
//        }




    }
}
