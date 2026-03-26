package it.unibo.pps.tasks.adts

/*  Exercise 1: 
 *  Complete the implementation of ComplexADT trait below, so that it passes
 *  the test in ComplexTest.
 */

object Ex1ComplexNumbers:

  trait ComplexADT:
    type Complex
    def complex(re: Double, im: Double): Complex
    extension (complex: Complex)
      def re(): Double
      def im(): Double
      def sum(other: Complex): Complex
      def subtract(other: Complex): Complex
      def asString(): String

  object BasicComplexADT extends ComplexADT:

    // Change assignment below: should probably define a case class and use it?
    case class complexNumber(real: Double, imaginary: Double)

    type Complex = complexNumber
    def complex(re: Double, im: Double): Complex = complexNumber(re, im)
    extension (complex: Complex)
      def re(): Double = complex.real
      def im(): Double = complex.imaginary
      def sum(other: Complex): Complex = complexNumber(complex.real + other.real, complex.imaginary + other.imaginary)
      def subtract(other: Complex): Complex = complexNumber(complex.real - other.real, complex.imaginary - other.imaginary)
      def asString(): String = (complex.real, complex.imaginary) match
        case (r, i) if r != 0 && i > 0 => r.toString + " + " + math.abs(i) + "i"
        case (r, i) if r != 0 && i < 0 => r.toString + " - " + math.abs(i) + "i"
        case (r, i) if r == 0 && i != 0 => i.toString + "i"
        case _ => complex.real.toString