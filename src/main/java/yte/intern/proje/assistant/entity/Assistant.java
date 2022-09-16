package yte.intern.proje.assistant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.proje.common.entity.BaseEntity;
import yte.intern.proje.lecture.entity.Lecture;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "assistants")
@Getter
@NoArgsConstructor
public class Assistant extends BaseEntity {
    private String name;
    private String surname;
    private String email;

    public Assistant(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @ManyToMany(mappedBy = "assistants")
    protected Set<Lecture> lectures = new HashSet<>();

    public void update(Assistant newAssistant) {
        this.name = newAssistant.name;
        this.surname = newAssistant.surname;
        this.email = newAssistant.email;
    }

    public void addLecture(Lecture lecture){
        this.lectures.add(lecture);
    }

    public void clearAssistant(){
        this.lectures.clear();
    }

}
