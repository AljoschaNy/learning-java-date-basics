package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Animal {
    private String name;
    private LocalDate birthday;

    public Animal(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public long getDaysToNextBirthday() {
        int monthOfBirthday = this.birthday.getMonthValue();
        int dayOfBirthday = this.birthday.getDayOfMonth();
        LocalDate thisYearBirthday = LocalDate.of(LocalDate.now().getYear(),monthOfBirthday,dayOfBirthday);
        long daysToNextBirthday = 0;

        if(thisYearBirthday.isEqual(LocalDate.now())) {
            System.out.println("It's your birthday");
        } else if(thisYearBirthday.isAfter(LocalDate.now())) {
            daysToNextBirthday = ChronoUnit.DAYS.between(LocalDate.now(),thisYearBirthday);
        } else {
            int nextYear = LocalDate.now().plusYears(1).getYear();
            LocalDate nextBirthday = LocalDate.of(nextYear,monthOfBirthday,dayOfBirthday);
            daysToNextBirthday = ChronoUnit.DAYS.between(LocalDate.now(),nextBirthday);
        }

        System.out.println("\n");
        System.out.println(daysToNextBirthday + " more days to wait =)");
        return daysToNextBirthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(birthday, animal.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
