package it.unibo.pps.tasks.adts

import it.unibo.pps.tasks.adts.SchoolModel.{BasicSchoolModule, SchoolModule}
import org.junit.Test
import org.junit.Assert.assertEquals
import it.unibo.pps.u03.extensionmethods.Sequences.Sequence, Sequence.*

class SchoolTest:
  val schoolModule: SchoolModule = BasicSchoolModule
  import schoolModule.*
  val emptySchool: School = schoolModule.emptySchool

  @Test def emptySchoolShouldHaveNoCourses(): Unit =
    assertEquals(Nil(), emptySchool.courses)

  @Test def emptySchoolShouldHaveNoTeachers(): Unit =
    assertEquals(Nil(), emptySchool.teachers)