import java.util.Set;

public class Donkey extends Pack {
    public Donkey(String name, Integer age) {
        super(name, age, AnimalType.Donkey);
    }

    public Donkey(String name, Integer age, Set<String> commands) {
        super(name, age, commands, AnimalType.Donkey);
    }
}