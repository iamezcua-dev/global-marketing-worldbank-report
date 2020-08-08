lazy val projectSettings = Seq(
  name := "global-marketing-worldbank-report",
  organization := "com.autoscheduler",
  maintainer := "iamezcua.dev@gmail.com",
  version := "0.1",
  scalaVersion := "2.13.1",
)

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "1.5.10.RELEASE",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.11.2",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
)


lazy val globalMarketingWorldbankReport = ( project in file( "." ) )
    .enablePlugins( JavaAppPackaging )
    .settings( projectSettings: _* )
    .settings(
      mainClass in assembly := Some( "com.autoscheduler.Application" )
    )

assemblyMergeStrategy in assembly := {
  case PathList( "META-INF", xs @ _* ) => MergeStrategy.discard
  case _ => MergeStrategy.first
}
