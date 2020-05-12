package errorsandexceptions.university;

import errorsandexceptions.university.exceptions.FacultyHasNoGroupsException;
import errorsandexceptions.university.exceptions.GradeOutOfRangeException;
import errorsandexceptions.university.exceptions.GroupHasNoStudentsException;
import errorsandexceptions.university.exceptions.StudentHasNoSubjectsException;
import errorsandexceptions.university.exceptions.UniversityHasNoFaculties;
import java.util.List;

public class DeansOffice {

  public static double calculateAverageStudentGrade(Student student)
      throws StudentHasNoSubjectsException, GradeOutOfRangeException {
    double averageGrade = 0;
    List<Subject> bunchOfSubjects = student.getBunchOfSubjects();
    if (bunchOfSubjects.isEmpty()) {
      throw new StudentHasNoSubjectsException("Student has no subjects");
    }
    for (Subject subject : bunchOfSubjects) {
      if (subject.getGrade() < 0 || subject.getGrade() > 10) {
        throw new GradeOutOfRangeException("Grade supposed to be in the range from 0 to 10");
      }
      averageGrade += subject.getGrade();
    }
    averageGrade = averageGrade / bunchOfSubjects.size();
    return averageGrade;
  }

  public static double calculateAverageSubjectGradeInGroup(CourseOfStudy course, Group group)
      throws GroupHasNoStudentsException {
    double averageGrade = 0;
    int numberOfStudentsWithTheCourse = 0;
    List<Student> bunchOfStudents = group.getBunchOfStudents();
    if (bunchOfStudents.isEmpty()) {
      throw new GroupHasNoStudentsException("Group " + group.getName() + "has no students");
    }
    for (Student student : bunchOfStudents) {
        if (student.findGrade(course).isPresent()) {
          averageGrade += student.findGrade(course).get();
          numberOfStudentsWithTheCourse++;
        }
    }
    averageGrade = averageGrade / numberOfStudentsWithTheCourse;
    return averageGrade;
  }

  public static double calculateAverageSubjectGradeInFaculty(CourseOfStudy course, Faculty faculty)
      throws FacultyHasNoGroupsException {
    double averageGrade = 0;
    int numberOfStudentsWithTheCourse = 0;
    List<Group> bunchOfGroups = faculty.getBunchOfGroups();
    if (bunchOfGroups.isEmpty()) {
      throw new FacultyHasNoGroupsException("Faulty " + faculty.getName() + "has no groups");
    }
    for (Group group: bunchOfGroups) {
        for (Student student : group.getBunchOfStudents()) {
          if (student.findGrade(course).isPresent()) {
            averageGrade += student.findGrade(course).get();
            numberOfStudentsWithTheCourse++;
          }
        }
    }
    averageGrade = averageGrade / numberOfStudentsWithTheCourse;
    return averageGrade;
  }

  public static double calculateAverageSubjectGradeInUniversity (CourseOfStudy course, University university)
      throws UniversityHasNoFaculties {
    double averageGrade = 0;
    int numberOfStudentsWithTheCourse = 0;
    List<Faculty> bunchOfFaculties = university.getBunchOfFaculties();
    if (bunchOfFaculties.isEmpty()) {
      throw new UniversityHasNoFaculties("There is no faculties in " + university.getName());
    }
    for (Faculty faculty : bunchOfFaculties) {
      for (Group group : faculty.getBunchOfGroups()) {
        for (Student student : group.getBunchOfStudents()) {
          if (student.findGrade(course).isPresent()) {
            averageGrade += student.findGrade(course).get();
            numberOfStudentsWithTheCourse++;
          }
        }
      }
    }
    averageGrade = averageGrade / numberOfStudentsWithTheCourse;
    return averageGrade;
  }

}
