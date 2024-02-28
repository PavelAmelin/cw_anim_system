import java.util.Set;

public class Hamster extends Pet {
    public Hamster(String name, Integer age) {
        super(name, age, AnimalType.Hamster);
    }

    public Hamster(String name, Integer age, Set<String> commands) {
        super(name, age, commands, AnimalType.Hamster);
    }
}