package ua.opnu;

public class TimeSpan {

    // Поля класу
    private int hours;   // години
    private int minutes; // хвилини (0-59)

    // Конструктор
    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Неправильні значення годин або хвилин");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    // Повертає години без хвилин
    public int getHours() {
        return hours;
    }

    // Повертає хвилини без годин
    public int getMinutes() {
        return minutes;
    }

    // Додає години і хвилини
    public void add(int addHours, int addMinutes) {
        if (addHours < 0 || addMinutes < 0 || addMinutes > 59) {
            throw new IllegalArgumentException("Неправильні значення годин або хвилин");
        }
        this.minutes += addMinutes;
        this.hours += addHours + this.minutes / 60;
        this.minutes %= 60;
    }

    // Додає інший TimeSpan
    public void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    // Повертає загальні години у вигляді дробового числа
    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    // Повертає загальні хвилини
    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    // Віднімає інший TimeSpan
    public void subtract(TimeSpan span) {
        int totalThis = getTotalMinutes();
        int totalSpan = span.getTotalMinutes();

        if (totalSpan > totalThis) {
            throw new IllegalArgumentException("Вхідний інтервал більший за поточний");
        }

        int totalResult = totalThis - totalSpan;
        this.hours = totalResult / 60;
        this.minutes = totalResult % 60;
    }

    // Масштабує інтервал
    public void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Фактор повинен бути більше нуля");
        }

        int totalMinutes = getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
