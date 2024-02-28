import java.util.Set;

public class Cat extends Pet{
    public Cat(String name, Integer age) {
        super(name, age, AnimalType.Cat);
    }

    public Cat(String name, Integer age, Set<String> commands) {
        super(name, age, commands, AnimalType.Cat);
    }
}