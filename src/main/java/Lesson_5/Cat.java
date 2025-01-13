package Lesson_5;

class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiated = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    protected int getRunLimit() {
        return 200;
    }

    @Override
    protected int getSwimLimit() {
        return 0;
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.getFoodAmount() >= foodAmount) {
            bowl.takeFood(foodAmount);
            satiated = true;
            System.out.println(getName() + " съел " + foodAmount + " рыбки из миски");
        } else {
            System.out.println(getName() + " не смог съесть " + foodAmount + " рыбок");
        }
    }

    public boolean isSatiated() {
        return satiated;
    }
}

