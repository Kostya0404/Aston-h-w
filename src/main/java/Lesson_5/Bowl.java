package Lesson_5;

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void takeFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        } else {
            System.out.println("В миске недостаточно еды");
        }
    }

    public void addFood(int amount) {
        foodAmount += amount;
    }
}