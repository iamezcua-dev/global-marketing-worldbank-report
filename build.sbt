lazy val projectSettings = Seq(
  name := "global-marketing-worldbank-report",
  organization := "com.autoscheduler",
  maintainer := "iamezcua.dev@gmail.com",
  version := "0.1",
  scalaVersion := "2.13.1",
)

lazy val springVersion = "1.5.10.RELEASE"

lazy val globalMarketingWorldbankReport = ( project in file( "." ) )
    .enablePlugins( JavaAppPackaging )
    .settings( projectSettings: _* )
    .settings(
      libraryDependencies ++= Seq(
        "org.springframework.boot" % "spring-boot-starter-web" % springVersion,
        "org.springframework.boot" % "spring-boot-starter-data-jpa" % springVersion,
        "jakarta.xml.bind" % "jakarta.xml.bind-api" % "2.3.2",
        "org.xerial" % "sqlite-jdbc" % "3.25.2",
        "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.11.2",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2" ),
      mainClass in assembly := Some( "com.autoscheduler.Application" )
    )

assemblyMergeStrategy in assembly := {
  case PathList( "META-INF", xs @ _* ) => MergeStrategy.discard
  case _ => MergeStrategy.first
}
