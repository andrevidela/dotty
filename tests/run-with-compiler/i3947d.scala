
import scala.quoted._
import dotty.tools.dotc.quoted.Toolbox._

object Test {

  def main(args: Array[String]): Unit = {

    def test[T](clazz: java.lang.Class[T]): Unit = {
      val lclazz = clazz.toExpr
      val name = '{ (~lclazz).getCanonicalName }
      println()
      println(name.show)
      println(name.run)
    }

    test(classOf[Foo])
    test(classOf[Foo#Bar])
    test(classOf[Foo.Baz])

    test(classOf[foo.Foo])
    test(classOf[foo.Foo#Bar])
    test(classOf[foo.Foo.Baz])
  }

}

class Foo {
  class Bar
}

object Foo {
  class Baz
}

package foo {
  class Foo {
    class Bar
  }
  object Foo {
    class Baz
  }
}