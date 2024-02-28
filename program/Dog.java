import java.util.Set;

public class Dog extends Pet {
    public Dog(String name, Integer age) {
        super(name, age, AnimalType.Dog);
    }

    public Dog(String name, Integer age, Set<String> commands) {
        super(name, age, commands, AnimalType.Dog);
    }
}