import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => ru}
import scala.reflect.runtime.{currentMirror => cm}
import scala.tools.reflect.ToolBox

object Test extends dotty.runtime.LegacyApp {
  def foo(y: Int): Int => Int = {
    def y1 = y

    val fun = reify{(x: Int) => {
      x + y1
    }}

    val toolbox = cm.mkToolBox()
    val dyn = toolbox.eval(fun.tree)
    dyn.asInstanceOf[Int => Int]
  }

  println(foo(1)(10))
  println(foo(2)(10))
}
