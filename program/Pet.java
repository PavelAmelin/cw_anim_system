import java.util.Set;

public class Pet extends Animal {
    protected Pet(String name, Integer age, AnimalType type){
        super(name, age, type);
    }

    protected Pet(String name, Integer age, Set<String> commands, AnimalType type) {
        super(name, age, commands, type);
    }
}