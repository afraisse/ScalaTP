package complex

import scala.math.{Pi, sqrt}

object TestV5 {
  var score = 0
  var total = 0

  def main(args: Array[String]): Unit = {
    test()
    println("-----------------------------------------------------------")
    println("Score final : " + score + " / " + total);
  }

  private def test() {
    val a = Complex(1,-1)
    testCoordinates(a, 1.0, -1.0, sqrt(2.0), (7.0 * Pi / 4.0))

    val b: Complex = Complex(2, new Angle(Pi/2.0))
    testCoordinates(b, 0.0, 2.0, 2.0, (Pi / 2.0))

    val c: Complex = a + b
    testEquality(c, Complex(1.0, 1.0))
    testCoordinates(c, 1.0, 1.0, sqrt(2.0), Pi / 4.0)

    val d: Complex = a * c
    testEquality(d, Complex(2.0, 0.0))
    testCoordinates(d, 2.0, 0.0, 2.0, 0.0)

    val e = a.inverse()
    testCoordinates(e, 0.5, 0.5, sqrt(0.5), (Pi / 4))

    val f = Complex(2, new Angle(Pi / 4.0)) ^ 8
    testEquality(f, Complex(256, 0))
  }

  private def testCoordinates(c: Complex,
                              real: Double, imag: Double, radius: Double, azimuth: Double){
    total = total + 1
    if (Comparison.isEqual(c.real, real))
      score = score + 1
    else {
      println("-----------------------------------------------------------")
      println("Error for complex " + c + ": " + c.getClass())
      println("x = " + c.real + " instead of " + real)
    }
    total = total+1
    if (Comparison.isEqual(c.imag, imag))
      score = score + 1
    else {
      println("-----------------------------------------------------------")
      println("Error for complex " + c + ": " + c.getClass())
      println("y = " + c.imag + " instead of " + imag)
    }
    total = total + 1
    if (Comparison.isEqual(c.radius, radius))
      score = score + 1
    else {
      println("-----------------------------------------------------------")
      println("Error for complex " + c + ": " + c.getClass())
      println("radius = " + c.radius + " instead of " + radius)
    }
    total = total + 1
    if (Comparison.isEqual(c.azimuth.angle, azimuth))
      score = score + 1
    else {
      println("-----------------------------------------------------------")
      println("Error for complex " + c + ": " + c.getClass())
      System.out.println("theta = " + c.azimuth.angle + " instead of " + azimuth)
    }
  }

  def testEquality(c1: Complex, c2: Complex){
    total = total + 1
    if(c1 == c2)
      score = score + 1
    else {
      println("-----------------------------------------------------------")
      println("Error in equality test: "
        + c1 + ": " + c1.getClass()
        + " equal to " + c2 + " : " + c2.getClass() )
    }
  }
}