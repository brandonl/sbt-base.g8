import sbt._
import sbt.Keys._

object BuildSettings {
  val buildSettings =
    Defaults.defaultSettings ++
      Seq( organization := "$organization$",
           version := "$version$",
           scalaVersion := "2.11.1",
           scalacOptions := Seq( "-unchecked", "-deprecation", "-feature" ),
           scalaSource in Compile <<= baseDirectory( _ / "src" / "main" ),
           scalaSource in Test <<= baseDirectory( _ / "src" / "test" ),
           resolvers ++= Seq( "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
                              "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"))
}

object Build extends Build {
  import BuildSettings._

  lazy val $name;format="word-only,camel"$ = Project(
    "$name$",
    file( "." ),
    settings = buildSettings ++ Seq(
      libraryDependencies := Seq()))
}

