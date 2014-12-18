lazy val root = (project in file(".")).settings(
  name := "jackson-module-scala-bugreport",
  libraryDependencies ++= Seq(
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.4.4" % "test",
    "org.scalatest" %% "scalatest" % "2.2.1" % "test"
  )
)
