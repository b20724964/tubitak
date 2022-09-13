package yte.intern.proje.academician.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.proje.common.entity.BaseEntity;
import yte.intern.proje.lecture.entity.Lecture;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "academicians")
@Getter
@NoArgsConstructor
public class Academician extends BaseEntity {
    private String name;
    private String surname;
    private String email;

    public Academician(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @ManyToMany(mappedBy = "academicians")
    protected Set<Lecture> lectures = new HashSet<>();

    public void update(Academician newAcademician) {
        this.name = newAcademician.name;
        this.surname = newAcademician.surname;
        this.email = newAcademician.email;
    }

    public void addLecture(Lecture lecture){
        this.lectures.add(lecture);
    }

}
