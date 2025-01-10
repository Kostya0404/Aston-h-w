package Lesson_5;

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    protected int getRunLimit() {
        return 500;
    }

    @Override
    protected int getSwimLimit() {
        return 10;
    }
}
