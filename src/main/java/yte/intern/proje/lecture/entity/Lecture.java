package yte.intern.proje.lecture.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.proje.academician.entity.Academician;
import yte.intern.proje.assistant.entity.Assistant;
import yte.intern.proje.common.entity.BaseEntity;
import yte.intern.proje.room.entity.Room;
import yte.intern.proje.student.entity.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "lectures")
@Getter
@NoArgsConstructor
public class Lecture extends BaseEntity {
    private String name;
    private String description;
    private LectureType type;
    private String lectureCode;


    public Lecture(String name, String description, LectureType type, String lectureCode) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.lectureCode = lectureCode;
    }


    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "LECTURE_STUDENT",
            joinColumns = @JoinColumn(name = "LECTURE_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID")
    )
    protected Set<Student> students = new HashSet<>();

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "LECTURE_ACADEMICIAN",
            joinColumns = @JoinColumn(name = "LECTURE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACADEMICIAN_ID")
    )
    protected Set<Academician> academicians = new HashSet<>();

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "LECTURE_ASSISTANT",
            joinColumns = @JoinColumn(name = "LECTURE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ASSISTANT_ID")
    )
    protected Set<Assistant> assistants = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "ROOM_ID", nullable = false)
    private Room room;

    public void update(Lecture newLecture) {
        this.description=newLecture.description;
    }

    public void addStudent(Student student) {
       if (student != null) {
           student.addLecture(this);
       }
        this.students.add(student);
    }

    public void removeStudent(Student student){
        student.removeLecture(this);
        this.students.remove(student);
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

    public void clearLecture(){
        this.students.clear();
        this.assistants.clear();
        this.academicians.clear();
    }

}
