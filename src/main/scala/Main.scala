import io.circe._ // Json の型のためにつかっているが、なくても動く
import io.circe.generic.auto._ // for Encoder: asJson で用いる
import io.circe.parser._  // for decode
import  io.circe.syntax._ // for asJson

sealed trait Foo
case class Bar(xs: Vector[String]) extends Foo
case class Qux(i: Int, d: Option[Double]) extends Foo

object Main extends App {
  
  val foo: Foo = Qux(13, Some(14.0))
  
  val jsonNoSpaces: String = foo.asJson.noSpaces
  println(jsonNoSpaces)
  
  
  val jsonSpaces: Json  = foo.asJson // Json はcirce での型
  println(jsonSpaces) // one-liner ではない
  
  val decodedFooNoSpaces = decode[Foo](jsonNoSpaces)
  println(decodedFooNoSpaces)
  
  
}
