package yte.intern.proje.lecture.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.proje.common.entity.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
public class LectureDate extends BaseEntity {
    private LocalDate date;
    private boolean lesson1;
    private boolean lesson2;
    private boolean lesson3;
    private boolean lesson4;
    private boolean lesson5;
    private boolean lesson6;
    private boolean lesson7;
    private boolean lesson8;

    public LectureDate(LocalDate date, boolean lesson1, boolean lesson2, boolean lesson3, boolean lesson4, boolean lesson5, boolean lesson6, boolean lesson7, boolean lesson8) {
        this.date = date;
        this.lesson1 = lesson1;
        this.lesson2 = lesson2;
        this.lesson3 = lesson3;
        this.lesson4 = lesson4;
        this.lesson5 = lesson5;
        this.lesson6 = lesson6;
        this.lesson7 = lesson7;
        this.lesson8 = lesson8;
    }

    public LectureDate() {
        this.date = LocalDate.now();
        this.lesson1 = false;
        this.lesson2 = false;
        this.lesson3 = false;
        this.lesson4 = false;
        this.lesson5 = false;
        this.lesson6 = false;
        this.lesson7 = false;
        this.lesson8 = false;
    }
}
