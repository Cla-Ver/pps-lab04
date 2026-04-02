package it.unibo.pps.tasks.adts

import it.unibo.pps.u03.Optionals.Optional
import it.unibo.pps.u03.Sequences.*

/*  Exercise 3: 
 *  Implement a Stack ADT
 *  Suggestion: 
 *  - push adds an element and returns the new stack
 *  - pop returns:
 *  -- empty optional is stack is empty
 *  -- a pair of top of the stack and the new stack after removal if not empty
 */
object Ex3Stacks:

  trait StackADT:
    type Stack[A]
    def empty[A]: Stack[A] // factory
    extension [A](stack: Stack[A])
      def push(a: A): Stack[A]
      def pop(): Optional[(A, Stack[A])]
      def asSequence(): Sequence[A]

  object StackImpl extends StackADT:
    case class StackImpl[A](stack: Sequence[A])
    opaque type Stack[A] = StackImpl[A]
    def empty[A]: Stack[A] = StackImpl(Sequence.Nil())
    extension [A](stack: Stack[A])
      def push(a: A): Stack[A] = StackImpl(Sequence.Cons(a, stack.stack))
      def pop(): Optional[(A, Stack[A])] = stack.stack match
        case Sequence.Cons(h, t) => Optional.Just(h, StackImpl(t))
        case _ => Optional.Empty()

      def asSequence(): Sequence[A] = stack.stack
