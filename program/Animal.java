import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.logging.Handler;

public class Animal {
    protected String name;
    protected Integer age;
    protected Set<String> commands;
    protected AnimalType type;

    protected Animal() {
    }

    protected Animal(String name, Integer age, AnimalType type) {
        this.name = name;
        this.age = age;
        this.commands = new LinkedHashSet<>();
        this.type = type;
    }

    protected Animal(String name, Integer age, Set<String> commands, AnimalType type) {
        this.name = name;
        this.age = age;
        this.commands = commands;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getCommands() {
        return commands;
    }

    public Boolean addCommand(String command) {
        return commands.add(command);
    }

    public AnimalType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(";");
        joiner.add(type.name());
        joiner.add(name);
        joiner.add(age.toString());

        String all_commands = "";
        for (String command: commands) {
            if (all_commands != "")
                all_commands += ", ";
            all_commands += command;
        }
        if (all_commands == "")
        all_commands = " ";

        joiner.add(all_commands);
        joiner.add("");

        return joiner.toString();
    }

    public static Animal parse(CharSequence input) throws RuntimeException {
        String[] spl = input.toString().split(";");
        Set<String> commands = new LinkedHashSet<String>();

        if (spl.length >= 4) {
            String[] cmds = spl[3].split(", ");
            for (String cmd: cmds) {
                String cmd_trim = cmd.trim().replaceAll("\\s+", " ");
                if (cmd_trim != "")
                    commands.add(cmd_trim);
            }
        }

        try {
            spl[0] = spl[0].trim().replaceAll("\\s+", " ");
            spl[1] = spl[1].trim().replaceAll("\\s+", " ");
            spl[2] = spl[2].trim().replaceAll("\\s+", " ");
            String val = spl[0];
            AnimalType type = AnimalType.valueOf(val);
            String name = spl[1];
            Integer age = Integer.parseInt(spl[2]);

            switch (type) {
                case Dog:
                    return new Dog(name, age, commands);
                case Cat:
                    return new Cat(name, age, commands);
                case Hamster:
                    return new Hamster(name, age, commands);
                case Horse:
                    return new Horse(name, age, commands);
                case Camel:
                    return new Camel(name, age, commands);
                case Donkey:
                    return new Donkey(name, age, commands);
                default:
                    throw new RuntimeException();
            }

        }
        catch (Exception e) {
            throw new RuntimeException("Некорректный ввод", e);
        }
    }
}