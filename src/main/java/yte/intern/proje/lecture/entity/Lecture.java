package yte.intern.proje.lecture.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.proje.academician.entity.Academician;
import yte.intern.proje.assistant.entity.Assistant;
import yte.intern.proje.common.entity.BaseEntity;
import yte.intern.proje.student.entity.Student;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "lectures")
@Getter
@NoArgsConstructor
public class Lecture extends BaseEntity {
    private String name;
    private String description;
    private LectureType type;
    private String lectureCode;
    private Room room;

    public Lecture(String name, String description, LectureType type, String lectureCode, Room room) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.lectureCode = lectureCode;
        this.room = room;
    }
    @OneToMany
    @JoinColumn(name = "lecture_id")
    private List<LectureDate> dates = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "LECTURE_STUDENT",
            joinColumns = @JoinColumn(name = "LECTURE_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID")
    )
    protected Set<Student> students = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "LECTURE_ACADEMICIAN",
            joinColumns = @JoinColumn(name = "LECTURE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACADEMICIAN_ID")
    )
    protected Set<Academician> academicians = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "LECTURE_ASSISTANT",
            joinColumns = @JoinColumn(name = "LECTURE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ASSISTANT_ID")
    )
    protected Set<Assistant> assistants = new HashSet<>();


    public void update(Lecture newLecture) {
        this.description=newLecture.description;
        this.room=newLecture.room;
        this.dates=newLecture.dates;

    }
    public void addStudent(Student student) {
       if (student != null) {
           student.addLecture(this);
       }
        this.students.add(student);
    }

    public void addAcademician(Academician academician) {
        if (academician != null) {
            academician.addLecture(this);
        }
        this.academicians.add(academician);
    }

    public void addAssistant(Assistant assistant) {
        if (assistant != null) {
            assistant.addLecture(this);
        }
        this.assistants.add(assistant);
    }


}
