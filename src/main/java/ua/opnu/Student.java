package ua.opnu;

import java.util.ArrayList;

public class Student {
    private String name;
    private int year; // від 1 до 4
    private ArrayList<String> courses; // список дисциплін

    // Конструктор
    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я не може бути порожнім");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання повинен бути від 1 до 4");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    // Додає дисципліну
    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            throw new IllegalArgumentException("Назва дисципліни не може бути порожньою");
        }
        courses.add(courseName);
    }

    // Видаляє всі дисципліни
    public void dropAll() {
        courses.clear();
    }

    // Повертає кількість дисциплін
    public int getCourseCount() {
        return courses.size();
    }

    // Повертає ім'я студента
    public String getName() {
        return name;
    }

    // Повертає рік навчання
    public int getYear() {
        return year;
    }

    // Повертає суму грошей, сплачену за навчання
    public int getTuition() {
        return year * 20000;
    }

    // Тестовий main
    public static void main(String[] args) {
        // Створюємо студента
        Student student = new Student("Іван", 2);

        // Додаємо дисципліни
        student.addCourse("Математика");
        student.addCourse("Фізика");
        student.addCourse("Програмування");

        // Виводимо кількість дисциплін
        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());

        // Виводимо рік навчання
        System.out.println(student.getName() + ": рік навчання - " + student.getYear());

        // Виводимо суму, сплачену за навчання
        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());
    }
}
