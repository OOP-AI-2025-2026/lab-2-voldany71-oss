package ua.opnu;

public class TimeSpan {

    // Поле для хранения общего количества минут
    private int totalMinutes;

    // Конструктор
    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Неправильні значення годин або хвилин");
        }
        this.totalMinutes = hours * 60 + minutes;
    }

    // Получить количество часов без учета минут
    int getHours() {
        return totalMinutes / 60;
    }

    // Получить количество минут без учета часов
    int getMinutes() {
        return totalMinutes % 60;
    }

    // Добавить часы и минуты
    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Неправильні значення годин або хвилин");
        }
        totalMinutes += hours * 60 + minutes;
    }

    // Добавить другой TimeSpan
    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    // Получить общее количество часов в виде дробного числа
    double getTotalHours() {
        return totalMinutes / 60.0;
    }

    // Получить общее количество минут
    int getTotalMinutes() {
        return totalMinutes;
    }

    // Вычесть другой TimeSpan
    void subtract(TimeSpan span) {
        int result = totalMinutes - span.totalMinutes;
        if (result < 0) {
            throw new IllegalArgumentException("Вхідний інтервал більший за поточний");
        }
        totalMinutes = result;
    }

    // Увеличить TimeSpan в factor раз
    void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Фактор повинен бути більше нуля");
        }
        totalMinutes *= factor;
    }
}
