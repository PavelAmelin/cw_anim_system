import java.util.Set;

public class Horse extends Pack {
    public Horse(String name, Integer age) {
        super(name, age, AnimalType.Horse);
    }

    public Horse(String name, Integer age, Set<String> commands) {
        super(name, age, commands, AnimalType.Horse);
    }
}