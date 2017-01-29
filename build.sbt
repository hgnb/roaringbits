val dependencies = Seq(
  "org.roaringbitmap" % "RoaringBitmap" % "0.6.34"
)

val commons = Seq(
  version      := "0.1.0-SNAPSHOT",
  organization := "com.github.hgnb",
  scalaVersion := "2.12.1"
)

val roaringbits = (project in file(".")).
  settings(
    commons,
    libraryDependencies ++= dependencies
  )

val segment = (project in file("examples/segment")).
  settings(
    commons,
    libraryDependencies ++= dependencies
  ).
  dependsOn(roaringbits)
