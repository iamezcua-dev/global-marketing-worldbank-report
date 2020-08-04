lazy val projectSettings = Seq(
  name := "global-marketing-worldbank-report",
  organization := "com.autoscheduler",
  version := "0.1",
  scalaVersion := "2.13.1"
)

lazy val globalMarketingWorldbankReport = ( project in file( "global-marketing-worldbank-report" ) )
    .settings( projectSettings: _* )
    .settings(
      mainClass in assembly := Some( "controllers.Application" )
    )