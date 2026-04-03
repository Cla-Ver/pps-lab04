package it.unibo.pps.tasks.typeclasses

import it.unibo.pps.u03.Sequences.Sequence, Sequence.*
import it.unibo.pps.u03.Optionals.Optional, Optional.*

/*  Exercise 5: 
 *  - Generalise by ad-hoc polymorphism logAll, such that:
 *  -- it can be called on Sequences but also on Optional, or others... 
 *  -- it does not necessarily call log, but any function with analogous type
 *  - Hint: introduce a type class Traversable[T[_]]], capturing the ability of calling a
 *    "consumer function" on all elements (with type A) of a datastructure T[A] 
 *    Note Traversable is a 2-kinded trait (similar to Filterable, or Monad)
 *  - Write givens for Traversable[Optional] and Traversable[Sequence]
 *  - Show you can use the generalisation of logAll to:
 *  -- log all elements of an Optional, or of a Traversable
 *  -- println(_) all elements of an Optional, or of a Traversable
 */

object Ex5Traversable:

  //def log[A](a: A): Unit = println("The next element is: "+a)

  def logAll[T[_]: Traversable, A](a: T[A]): Unit =
    summon[Traversable[?]].log(a)

  trait Traversable[T[_]]:
    def log[A](a: T[A]): Unit

  given Traversable[Optional]:
    override def log[A](a: Optional[A]): Unit = a match
      case Just(a) => println(a)
      case _ => ()

  given Traversable[Sequence]:
    override def log[A](a: Sequence[A]): Unit = a match
      case Cons(h, t) => println("The next element is: " + h); log(t)
      case _ => ()

  @main def tryTraversable(): Unit =
    val optional: Optional[Int] = Just(1)
    logAll(optional)

    val sequence: Sequence[Int] = Cons(1, Cons(2, Cons(3, Nil())))
    logAll(sequence)