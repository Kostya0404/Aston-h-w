package Lesson_8;

public class main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Сыс", "+375291167367");
        phoneBook.add("Агапов", "+375291234567");
        phoneBook.add("Логвинов", "+375291112233");
        phoneBook.add("Иванов", "+375299998877");
        phoneBook.add("Агапов", "+375293332211");

        System.out.println("Телефон Сыс " + phoneBook.get("Сыс"));
        System.out.println("Телефон Агапова " + phoneBook.get("Агапов"));
        System.out.println("Телефон Логвинова " + phoneBook.get("Логвинов"));
        System.out.println("Телефон Иванова " + phoneBook.get("Иванов"));
    }
}
