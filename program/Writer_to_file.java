import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer_to_file {
    private ArrayList<Animal> all_animals;

    public Writer_to_file() {
        all_animals = new ArrayList<>();
    }

    public void loader() throws IOException {
        File file = new File(
                "D:\\Geekbrains\\Hometask\\cw_anim_system\\program\\list_animals.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            all_animals.add(Animal.parse(line));
        }
        br.close();
    }

    public void writer() throws IOException {

        FileWriter writer = new FileWriter(
            "D:\\Geekbrains\\Hometask\\cw_anim_system\\program\\list_animals.txt", false);

            for (Animal animal : all_animals) {
                writer.append(animal.toString() + "\n");
            }

            writer.flush();
            writer.close();
        }

        public ArrayList<Animal> getAnimals() {
            return all_animals;
        }

        public void addAnimal(Animal animal) {
            all_animals.add(animal);
        }
    
} 

