package yte.intern.proje.lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.proje.lecture.entity.Lecture;

public interface LectureRepository  extends JpaRepository<Lecture, Long> {

}
