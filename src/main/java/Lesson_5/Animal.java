package Lesson_5;

public abstract class Animal {
    private String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        if (distance > getRunLimit()) {
            System.out.println(name + " не может пробежать " + distance + " м");
        } else {
            System.out.println(name + " пробежал " + distance + " м");
        }
    }

    public void swim(int distance) {
        if (distance > getSwimLimit()) {
            System.out.println(name + " не может проплыть " + distance + " м");
        } else {
            System.out.println(name + " проплыл " + distance + " м");
        }
    }

    protected abstract int getRunLimit();

    protected abstract int getSwimLimit();
}