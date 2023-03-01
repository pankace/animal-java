import java.util.UUID;

public class Animal {
    private UUID id;
    private String name;
    private String race;
    private double weight;
    private double maximumSpeed;

    public Animal(String name, String race, double weight, double maximumSpeed) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.race = race;
        this.weight = weight;
        this.maximumSpeed = maximumSpeed;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", weight=" + weight +
                ", maximumSpeed=" + maximumSpeed +
                '}';

    }

}
