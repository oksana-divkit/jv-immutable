package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = cloneWheels(wheels);
        this.engine = cloneEngine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneWheels(wheels);
    }

    public Engine getEngine() {
        return cloneEngine(engine);
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, cloneWheels(wheels), cloneEngine(engine));
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, cloneWheels(wheels), cloneEngine(engine));
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = cloneWheels(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, cloneEngine(engine));
    }

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && color == car.color
                    || color != null && color.equals(car.color)
                && wheels == car.wheels
                    || wheels != null && wheels.equals(car.wheels)
                && engine == car.engine
                    || engine != null && engine.equals(car.engine);
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }

    private List<Wheel> cloneWheels(List<Wheel> wheels) {
        List<Wheel> list = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
    }

    private Engine cloneEngine(Engine engine) {
        return engine == null ? null : engine.clone();
    }
}
