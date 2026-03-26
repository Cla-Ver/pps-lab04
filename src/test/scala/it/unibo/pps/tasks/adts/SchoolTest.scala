package it.unibo.pps.tasks.adts

import it.unibo.pps.tasks.adts.SchoolModel.{BasicSchoolModule, SchoolModule}
import org.junit.Test
import org.junit.Assert.assertEquals
import it.unibo.pps.u03.extensionmethods.Sequences.Sequence, Sequence.*

class SchoolTest:
  val schoolModule: SchoolModule = BasicSchoolModule
  import schoolModule.*

  @Test def emptySchoolShouldNotHaveCourses(): Unit =
    val emptySchool = schoolModule.emptySchool
    assertEquals(Nil(), emptySchool.courses)
