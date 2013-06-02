
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

  lazy val $name$ = Project(
    "$name;format="word-only,camel"",
    file( "." ),
    settings = buildSettings ++ Seq(
      libraryDependencies := Seq(
        Dependencies.Test.ScalaTest
        ) )
  )

  object Dependencies {

    object Compile {
      val ScalaLogging = "com.typesafe" %% "scalalogging-slf4j" % "1.0.+"
      val ScalaConfig = "com.typesafe" % "config" % "1.0.0"
      val LogbackCore = "ch.qos.logback" % "logback-core" % "1.0.+"
      val LogbackClassic = "ch.qos.logback" % "logback-classic" % "1.0.+"
    }

    object Test {
      val Mockito = "org.mockito" % "mockito-all" % "1.9.0" % "test"
      val ScalaTest = "org.scalatest" %% "scalatest_2.10" % "1.9.+" % "test"
      val ScalaCheck = "org.scalacheck" %% "scalacheck" % "1.10.+" % "test"
    }
  }
}

