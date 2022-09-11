package yte.intern.proje.student.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.proje.book.entity.Book;
import yte.intern.proje.common.entity.BaseEntity;
import yte.intern.proje.lecture.entity.Lecture;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "students")
@Getter
@NoArgsConstructor
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    //private String tcKimlikNo;
    private String studentNumber;

    public Student(String name, String surname, String email, String studentNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        //this.tcKimlikNo = tcKimlikNo;
        this.studentNumber = studentNumber;
    }

    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Book> books = new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    protected Set<Lecture> lectures = new HashSet<>();

    public void update(Student newStudent) {
        this.name = newStudent.name;
        this.surname = newStudent.surname;
        this.email = newStudent.email;
        this.studentNumber = newStudent.studentNumber;
    }

    public void addLecture(Lecture lecture) {
       // if(lecture != null){
       //     lecture.addStudent(this);
       // }
        this.lectures.add(lecture);
    }
}
