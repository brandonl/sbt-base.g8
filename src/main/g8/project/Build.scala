import sbt._
import sbt.Keys._

object BuildSettings {
  val buildSettings =
    Defaults.defaultSettings ++
      Seq( organization := "$organization$",
           version := "$version$",
           scalaVersion := "2.10.0",
           scalacOptions := Seq( "-unchecked", "-deprecation", "-feature" ),
           scalaSource in Compile <<= baseDirectory( _ / "src" / "main" ),
           scalaSource in Test <<= baseDirectory( _ / "src" / "test" ),
           resolvers ++= Seq(
                              "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
                              "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/")
         )
}

object Build extends Build {
  import BuildSettings._

  lazy val $name;format="word-only,camel"$ = Project(
    "$name$",
    file( "." ),
    settings = buildSettings ++ Seq(
      libraryDependencies := Seq(

        Dependencies.Runtime.ScalaConfig,
        Dependencies.Runtime.ScalaLogging,
        Dependencies.Runtime.LogbackCore,
        Dependencies.Runtime.LogbackClassic,
        Dependencies.Runtime.Slf4jApi,

        Dependencies.Test.ScalaTest,
        Dependencies.Test.Mockito
        ) )
  )

  object Dependencies {

    object Compile {
    }

    object Runtime {
      val ScalaLogging = "com.typesafe" %% "scalalogging-slf4j" % "1.1.+"
      val ScalaConfig = "com.typesafe" % "config" % "1.0.0"
      val LogbackCore = "ch.qos.logback" % "logback-core" % "1.0.+"
      val LogbackClassic = "ch.qos.logback" % "logback-classic" % "1.0.+"
      val Slf4jApi = "org.slf4j" % "slf4j-api" % "1.6.+"
    }

    object Test {
      val Mockito = "org.mockito" % "mockito-all" % "1.9.0" % "test"
      val ScalaTest = "org.scalatest" %% "scalatest" % "1.9.+" % "test"
    }
  }
}

