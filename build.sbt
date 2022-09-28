ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.8"

val ScalaTestVersion = "3.2.13"
val SparkVersion = "3.3.0"

lazy val root = (project in file("."))
  .settings(
    name := "ChineseCheckersGame",
    libraryDependencies ++= Seq (
      "org.scalactic"     %%  "scalactic"       % ScalaTestVersion,
      "org.scalatest"     %%  "scalatest"       % ScalaTestVersion  % "test",
      "org.apache.spark"  %   "spark-core_2.13" % SparkVersion      % "provided",
      "com.google.inject" %   "guice"           % "5.1.0"
    ),
    resolvers ++= Seq (
      "MavenRepository" at "https://mvnrepository.com/", // spark
      "Artima Maven Repository" at "https://repo.artima.com/releases" // scalatest & scalatic
    )
  )