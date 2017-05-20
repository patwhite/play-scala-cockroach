name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  cache,
  ws,
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc4",
  "com.typesafe.play" %% "play-slick" % "2.1.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "2.1.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)



fork in run := true