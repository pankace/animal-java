import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static AnimalCollection animalCollection;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the CSV file: ");
        String fileName = scanner.nextLine();
        animalCollection = new AnimalCollection(fileName);
        int option;
        do {
            System.out.println("Select an option:");
            System.out.println("1. Print animals by race");
            System.out.println("2. Print all races");
            System.out.println("3. Search for animal by name");
            System.out.println("4. Print total weight for a race");
            System.out.println("5. Add new animal");
            System.out.println("6. Remove animal by id");
            System.out.println("7. Remove all animals of a race");
            System.out.println("8. Print average speed for a race");
            System.out.println("9. Print total weight for all animals");
            System.out.println("0. Exit");
            try {
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        printAnimalsByRace(scanner);
                        break;
                    case 2:
                        printAllRaces();
                        break;
                    case 3:
                        searchAnimalByName(scanner);
                        break;
                    case 4:
                        printTotalWeightForRace(scanner);
                        break;
                    case 5:
                        addNewAnimal(scanner);
                        break;
                    case 6:
                        removeAnimalById(scanner);
                        break;
                    case 7:
                        removeAnimalsByRace(scanner);
                        break;
                    case 8:
                        printAverageSpeedForRace(scanner);
                        break;
                    case 9:
                        printTotalWeightForAllAnimals();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                option = -1;
            }
        } while (option != 0);
    }

    public static void printAnimalsByRace(Scanner scanner) {
        System.out.print("Enter the race: ");
        String race = scanner.nextLine();
        for (Animal animal : animalCollection.getAnimalsByRace(race)) {
            System.out.println(animal);
        }
    }

    public static void printAllRaces() {
        for (String race : animalCollection.getAllRaces()) {
            System.out.println(race);
        }
    }

    public static void searchAnimalByName(Scanner scanner) {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        Animal animal = animalCollection.getAnimalByName(name);
        if (animal == null) {
            System.out.println("Animal not found.");
        } else {
            System.out.println(animal);
        }
    }

    public static void printTotalWeightForRace(Scanner scanner) {
        System.out.print("Enter the race: ");
        String race = scanner.nextLine();
        double totalWeight = AnimalCollection.getTotalWeightByRace(race);
        System.out.println("Total weight for " + race + ": " + totalWeight);
    }

    public static void addNewAnimal(Scanner scanner) {
        String name, race;
        double weight, maximumSpeed;
        System.out.print("Enter the name: ");
        name = scanner.nextLine();
        System.out.print("Enter the race: ");
        race = scanner.nextLine();
        System.out.print("Enter the weight: ");
        weight = scanner.nextDouble();
        System.out.print("Enter the maximum speed: ");
        maximumSpeed = scanner.nextDouble();
        scanner.nextLine();
    }
}