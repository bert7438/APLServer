package ru.bert7438.aplserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "progress")
@NoArgsConstructor
@AllArgsConstructor
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "lesson_name")
    private String lessonName;
    @Column(name = "lecture_name")
    private String lectureName;
    @Column(name = "lesson")
    private int lesson;
    @Column(name = "lecture")
    private int lecture;
    @Column(name = "visit_lesson")
    private String visitLesson;
    @Column(name = "visit_lecture")
    private String visitLecture;
    @Column(name = "id_user")
    private int idUser;

    public Progress(String lessonName, String lectureName, int lesson, int lecture, String visitLesson, String visitLecture, int idUser) {
        this.lessonName = lessonName;
        this.lectureName = lectureName;
        this.lesson = lesson;
        this.lecture = lecture;
        this.visitLesson = visitLesson;
        this.visitLecture = visitLecture;
        this.idUser = idUser;
    }
}
