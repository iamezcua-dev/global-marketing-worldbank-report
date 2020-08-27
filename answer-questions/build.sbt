name := "answer-questions"

libraryDependencies ++= Seq(
  "org.xerial" % "sqlite-jdbc" % "3.25.2",
  "com.typesafe" % "config" % "1.4.0"
)
mainClass in assembly := Some( "com.autoscheduler.Application" )


    
    
    
