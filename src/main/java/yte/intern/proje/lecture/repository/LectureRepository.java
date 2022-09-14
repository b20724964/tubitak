package yte.intern.proje.lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yte.intern.proje.lecture.entity.Lecture;

import java.util.List;

public interface LectureRepository  extends JpaRepository<Lecture, Long> {
  // @Query(nativeQuery = true, //
  //         value = "SELECT studentId FROM lecture_student WHERE studentId=:studentId")
  // List<Long> getIdByStudentId(@Param("studentId") Long studentId);
}
