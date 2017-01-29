package com.github.hgnb.collection.mutable

import scala.collection.TraversableLike
import scala.collection.generic.{ Growable, Shrinkable }

import org.roaringbitmap.{ RoaringBitmap => BitMap }
import scala.collection.mutable.Builder

class RoaringBits private (private val inner: BitMap)
  extends Growable[Int]
  with Shrinkable[Int]
  with TraversableLike[Int, RoaringBits] /* with BitSetLike[RoaringBits] */ {

  def seq: TraversableOnce[Int] = ???

  def newBuilder: Builder[Int, RoaringBits] = ???

  def foreach[U](f: Int => U): Unit = ???

  def apply(i: Int): Boolean = inner.contains(i)

  def empty: RoaringBits = RoaringBits.empty

  def clear() = inner.clear()

  override def +=(i: Int): this.type = { inner.add(i); this }

  def ++=(xs: RoaringBits): this.type = { inner.or(xs.inner); this }

  override def ++=(xs: TraversableOnce[Int]): this.type = {
    for (i <- xs) inner.add(i)
    this
  }

  override def -=(i: Int): this.type = { inner.remove(i); this }

  def --=(that: RoaringBits): this.type = { ??? }

  override def --=(that: TraversableOnce[Int]): this.type = { ??? }

  /*
  override def add(elem: Int) = if(!inner.contains(elem)) {
    inner.add(elem)
    true
  } else {
    false
  }

  override def +(elem: Int): RoaringBits = {inner.add(elem); this}

  override def contains(i: Int): Boolean = inner.contains(i)

  override def &(that: BitSet): RoaringBits = {
    val inner = inner.clone()
    inner.and(Bits.bitmapOf(that.toSeq: _*))
    new RoaringBits(inner)
  }

  def &=(that: RoaringBits) = inner and that.inner

  override def &(that: GenSet[Int]): RoaringBits = {
    val inner = inner.clone()
    inner.and(Bits.bitmapOf(that.seq.toSeq: _*))
    new RoaringBits(inner)
  }

  override def +=(i: Int): this.type = {inner.add(i); this}
  def |=(that: RoaringBits) = inner or that.inner
  */

}

object RoaringBits {
  def apply(ints: Int*): RoaringBits = {
    val bitmap = BitMap.bitmapOf(ints: _*)
    new RoaringBits(bitmap)
  }

  def apply(bits: BitMap): RoaringBits = new RoaringBits(bits)

  def empty: RoaringBits = new RoaringBits(new BitMap())
}
