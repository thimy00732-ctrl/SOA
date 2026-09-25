name := """baithuchanh"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.18"

libraryDependencies ++= Seq(
  guice,
  "com.auth0" % "java-jwt" % "4.4.0"
)