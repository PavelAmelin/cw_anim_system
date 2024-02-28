import java.util.Set;

public class Pack extends Animal {
    protected Pack(String name, Integer age, AnimalType type){
        super(name, age, type);
    }

    protected Pack(String name, Integer age, Set<String> commands, AnimalType type) {
        super(name, age, commands, type);
    }
}