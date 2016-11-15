package scalatutorial.sections

/** @param name definitions_and_evaluation */
object DefinitionsAndEvaluation extends ScalaTutorialSection {

  /**
    * = Naming Things =
    *
    * Consider the following program that computes the area of a disc
    * whose radius is `10`:
    *
    * {{{
    *   3.14159 * 10 * 10
    * }}}
    *
    * To make complex expressions more readable we can give meaningful names to
    * intermediate expressions:
    *
    * {{{
    *   val radius = 10
    *   val pi = 3.14159
    *
    *   pi * radius * radius
    * }}}
    *
    * Besides making the last expression more readable it also allows us to
    * not repeat the actual value of the radius.
    *
    * = Evaluation =
    *
    * A name is evaluated by replacing it with the right hand side of its definition
    *
    * == Example ==
    *
    * Here are the evaluation steps of the above expression:
    *
    * {{{
    *   pi * radius * radius
    *   3.14159 * radius * radius
    *   3.14159 * 10 * radius
    *   31.4159 * radius
    *   31.4159 * 10
    *   314.159
    * }}}
    *
    * = Methods =
    *
    * Definitions can have parameters. For instance:
    */
  def square(x: Double) = x * x

  /**
    * And then you can ''call'' a method as follows:
    */
  def usingSquare(res0: Double): Unit = {
    square(3.0) shouldBe res0
  }

  /**
    * Let’s define a method that computes the area of a disc, given its radius:
    */
  def areaExercise(res0: Double): Unit = {
    def area(radius: Double): Double = 3.14159 * square(radius)

    area(10) shouldBe res0
  }

  /**
    * = Multiple Parameters =
    *
    * Separate several parameters with commas:
    */
  def sumOfSquares(x: Double, y: Double) = square(x) + square(y)

/**
  * = Parameters and Return Types =
  *
  * Function parameters come with their type, which is given after a colon
  *
  * {{{
  *   def power(x: Double, y: Int): Double = ...
  * }}}
  *
  * If a return type is given, it follows the parameter list.
  *
  * = Evaluation of Function Applications =
  *
  * Applications of parametrized functions are evaluated in a similar way as
  * operators:
  *
  *  1. Evaluate all function arguments, from left to right
  *  1. Replace the function application by the function's right-hand side, and, at the same time
  *  1. Replace the formal parameters of the function by the actual arguments.
  *
  * == Example ==
  *
  * {{{
  *   sumOfSquares(3, 2+2)
  *   sumOfSquares(3, 4)
  *   square(3) + square(4)
  *   3 * 3 + square(4)
  *   9 + square(4)
  *   9 + 4 * 4
  *   9 + 16
  *   25
  * }}}
  *
  * = The substitution model =
  *
  * This scheme of expression evaluation is called the ''substitution model''.
  *
  * The idea underlying this model is that all evaluation does is ''reduce
  * an expression to a value''.
  *
  * It can be applied to all expressions, as long as they have no side effects.
  *
  * The substitution model is formalized in the λ-calculus, which gives
  * a foundation for functional programming.
  *
  * = Termination =
  *
  * Does every expression reduce to a value (in a finite number of steps)?
  *
  * No. Here is a counter-example:
  *
  * {{{
  *   def loop: Int = loop
  *
  *   loop
  * }}}
  *
  * = Changing the evaluation strategy =
  *
  * The interpreter reduces function arguments to values before rewriting the
  * function application.
  *
  * One could alternatively apply the function to unreduced arguments.
  *
  * For instance:
  *
  * {{{
  *   sumOfSquares(3, 2+2)
  *   square(3) + square(2+2)
  *   3 * 3 + square(2+2)
  *   9 + square(2+2)
  *   9 + (2+2) * (2+2)
  *   9 + 4 * (2+2)
  *   9 + 4 * 4
  *   25
  * }}}
  *
  * = Call-by-name and call-by-value =
  *
  * The first evaluation strategy is known as ''call-by-value'',
  * the second is is known as ''call-by-name''.
  *
  * Both strategies reduce to the same final values
  * as long as
  *
  *  - the reduced expression consists of pure functions, and
  *  - both evaluations terminate.
  *
  * Call-by-value has the advantage that it evaluates every function argument
  * only once.
  *
  * Call-by-name has the advantage that a function argument is not evaluated if the
  * corresponding parameter is unused in the evaluation of the function body.
  */
  def nothing(): Unit = ()

}
