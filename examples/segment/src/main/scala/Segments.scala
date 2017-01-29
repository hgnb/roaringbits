import com.github.hgnb.collection.mutable.RoaringBits

object Segment extends App {
  val bits0 = RoaringBits(2, 3)
  val bits1 = RoaringBits(4, 5)
  val xs = bits0 ++= Seq(4, 5)
  val ys = bits0 ++= bits1
  println( (xs(4), ys(5)) )
}
