package data;

import models.Animal;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnimalData {
    private static Map<Integer, Animal> animals = new LinkedHashMap<>();

    public static Collection<Animal> getAll() {
        return animals.values();
    }

    public static void add(Animal animal) {
        animals.put(animal.getId(), animal);
    }

    public static Animal getById(Integer id) {
        return animals.get(id);
    }

    public static void remove(Integer id) {
        if (animals.containsKey(id)) {
            animals.remove(id);
        }
    }
}
