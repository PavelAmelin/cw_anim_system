import java.util.Set;

public class Camel extends Pack {
    public Camel(String name, Integer age) {
        super(name, age, AnimalType.Camel);
    }

    public Camel(String name, Integer age, Set<String> commands) {
        super(name, age, commands, AnimalType.Camel);
    }
}