import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Writer_to_file wr_anim;
    private static Scanner in;

    public static void main(String[] args) {
        wr_anim = new Writer_to_file();
        in = new Scanner(System.in);
        while (true) {
            printOperations();
            execOperation(getInt("Выберите операцию: "));
            getText("Для продолжения нажмите enter");
        }
    }

    public static void printOperations() {
        System.out.println("Операция");
        System.out.println("1. Загрузить список животных");
        System.out.println("2. Сохранить список животных");
        System.out.println("3. Вывести список животных");
        System.out.println("4. Добавление нового животного");
        System.out.println("5. Обучение новым командам");
        System.out.println("6. Вывести список животных по возрасту");
        System.out.println("7. Счетчик животных");
        System.out.println("0. Выход");
    }

    public static void execOperation(Integer operation) {
        try {
            switch (operation) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    loadAnimals();
                    break;
                case 2:
                    writeAnimals();
                    break;
                case 3:
                    printAnimal();
                    break;
                case 4:
                    addAnimal();
                    break;
                case 5:
                    addCommand();
                    break;
                case 6:
                    findAnimal();
                    break;
                case 7:
                    countAnimals();
                    break;
                default:
                    System.out.println("Команды не существует...");
                    break;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ошибка");
            e.printStackTrace();
            return;
        }
    }

    protected static Integer getInt() {
        while (true) {
            try {
                return Integer.parseInt(getText());
            } catch (Exception e) {
                System.out.println("Неправильный ввод");
            }
        }
    }

    protected static Integer getInt(String text) {
        System.out.print(text);
        return getInt();
    }

    protected static String getText() {
        return in.nextLine();
    }

    protected static String getText(String text) {
        System.out.print(text);
        return getText();
    }

    protected static Animal getAnimal() {
        while (true) {
            try {
                System.out.println("Добавьте животное в формате Type;Name;Age;(Тип;Имя;Возраст;): ");
                return Animal.parse(in.nextLine());
            } catch (Exception e) {
                continue;
            }
        }
    }

    protected static Animal getAnimalIndex() {
        while (true) {
            try {
                return wr_anim.getAnimals().get(getInt("Введите индекс животного: ") - 1);
            } catch (Exception e) {
                System.out.println("Животного не существует");
            }
        }
    }

    public static void printAnimal() {
        Integer index = 0;

        System.out.println();
        for (Animal animal : wr_anim.getAnimals()) {
            index += 1;
            String line = animal.toString().replace(";", " ");
            System.out.println(index + ". " + line);
        }
        System.out.println();
    }

    public static void loadAnimals() throws IOException {
        wr_anim.loader();
        System.out.println("Список животных загружен");
    }

    public static void writeAnimals() throws IOException {
        wr_anim.writer();
        System.out.println("Список животных записан");
    }

    public static void addAnimal() {
        wr_anim.addAnimal(getAnimal());
        System.out.println("Успешно добавлено");
    }

    public static void addCommand() {
        printAnimal();
        Animal animal = getAnimalIndex();
        System.out.print("Введите команду: ");
        String command = getText();
        animal.addCommand(command);
        System.out.println("Команда добавлена");
    }

    public static void findAnimal() {
        Integer age = getInt("Введите возраст животного: ");
        for (Animal animal : wr_anim.getAnimals) {
            if (animal.getAge().compareTo(age) != 0)
                continue;
            String line = animal.toString().replace(";", " ");
            System.out.println(line);
        }
    }

    public static void countAnimals() {
        Integer all_anim = 0, pet = 0, pack = 0;
        for (Animal animal : wr_anim.getAmimals()) {
            all += 1;
            if (animal instanceof Pet)
                pet += 1;
            if (animal instanceof Pack)
                pack += 1;
        }
        System.out.println("Всего: " + all);
        System.out.println("Домашних: " + pet);
        System.out.println("Вьючных: " + pack);
    }

}