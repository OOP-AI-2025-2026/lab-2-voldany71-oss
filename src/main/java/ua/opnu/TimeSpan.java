package ua.opnu;

public class TimeSpan {

    private int totalMinutes;

    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Неправильні значення годин або хвилин");
        }
        this.totalMinutes = hours * 60 + minutes;
    }

    int getHours() {
        return totalMinutes / 60;
    }

    int getMinutes() {
        return totalMinutes % 60;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return; // игнорируем некорректные значения
        }
        totalMinutes += hours * 60 + minutes;
    }

    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    double getTotalHours() {
        return totalMinutes / 60.0;
    }

    int getTotalMinutes() {
        return totalMinutes;
    }

    void subtract(TimeSpan span) {
        if (span.totalMinutes > totalMinutes) {
            return; // если вычитаемый интервал больше, ничего не делаем
        }
        totalMinutes -= span.totalMinutes;
    }

    void scale(int factor) {
        if (factor <= 0) {
            return; // игнорируем фактор <= 0
        }
        totalMinutes *= factor;
    }
}
