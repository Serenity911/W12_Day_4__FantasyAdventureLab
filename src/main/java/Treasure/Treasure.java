package Treasure;

public abstract class Treasure {
    private String name;
    private double value;

    public Treasure(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
