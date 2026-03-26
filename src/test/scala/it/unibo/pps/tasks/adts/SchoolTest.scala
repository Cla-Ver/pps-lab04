package it.unibo.pps.tasks.adts

import it.unibo.pps.tasks.adts.SchoolModel.{BasicSchoolModule, SchoolModule}
import org.junit.Test
import org.junit.Assert.assertEquals
import it.unibo.pps.u03.extensionmethods.Sequences.Sequence, Sequence.*

class SchoolTest:
  val schoolModule: SchoolModule = BasicSchoolModule
  import schoolModule.*
  val school: School = schoolModule.emptySchool
  val course: Course = schoolModule.course("PPS")
  val teacher: Teacher = schoolModule.teacher("Mario")

  @Test def emptySchoolShouldHaveNoCourses(): Unit =
    assertEquals(Nil(), school.courses)

  @Test def emptySchoolShouldHaveNoTeachers(): Unit =
    assertEquals(Nil(), school.teachers)

  @Test def schoolShouldHaveCourseAfterAdding(): Unit =
    assertEquals(Cons("PPS", Nil()), school.setTeacherToCourse(teacher, course).courses)

  @Test def schoolShouldHaveTeachersAfterAdding(): Unit =
    assertEquals(Cons("Mario", Nil()), school.setTeacherToCourse(teacher, course).teachers)