import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AnimalCollection {
    private List<Animal> animals;
    private String fileName;

    public AnimalCollection(String fileName) {
        animals = new ArrayList<>();
        this.fileName = fileName;
        loadData();
    }

    public void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                UUID id = UUID.fromString(values[0]);
                String name = values[1];
                String race = values[2];
                double weight = Double.parseDouble(values[3]);
                double maximumSpeed = Double.parseDouble(values[4]);
                Animal animal = new Animal(name, race, weight, maximumSpeed);
                animal.setId(id);
                animals.add(animal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Animal animal : animals) {
                fw.write(animal.getId() + "," + animal.getName() + "," + animal.getRace() + "," + animal.getWeight() + "," + animal.getMaximumSpeed() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        saveData();
    }

    public void removeAnimal(UUID id) {
        animals.removeIf(animal -> animal.getId().equals(id));
        saveData();
    }

    public void removeAnimalsByRace(String race) {
        animals.removeIf(animal -> animal.getRace().equals(race));
        saveData();
    }
//sorts each race of animal and puts in list
    public void sortrace() {
        List<Animal> sorted = new ArrayList<>();
        for (Animal animal : animals) {
            if (sorted.isEmpty()) {
                sorted.add(animal);
            } else {
                for (int i = 0; i < sorted.size(); i++) {
                    if (animal.getRace().compareTo(sorted.get(i).getRace()) < 0) {
                        sorted.add(i, animal);
                        break;
                    } else if (i == sorted.size() - 1) {
                        sorted.add(animal);
                        break;
                    }
                }
            }
        }
        animals = sorted;
        saveData();
    }

    public Animal getAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;

    }
//set id
    public void setAnimalId(UUID id, String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animal.setId(id);
            }
        }
        saveData();
    }
}
