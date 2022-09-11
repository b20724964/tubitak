package yte.intern.proje.academician.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.proje.common.entity.BaseEntity;
import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.student.entity.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    //@ManyToMany(cascade = CascadeType.PERSIST)
    //@JoinTable(
    //        name = "TAG_VEHICLE",
    //        joinColumns = @JoinColumn(name = "TAG_ID"),
    //        inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
    //)
    //protected List<Student> vehicles = new ArrayList<>();

    @ManyToMany(mappedBy = "academicians")
    protected Set<Lecture> lectures = new HashSet<>();

    public void update(Academician newAcademician) {
        this.name = newAcademician.name;
        this.surname = newAcademician.surname;
        this.email = newAcademician.email;
    }

}
