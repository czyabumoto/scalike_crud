name := "scalike_crud"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.scala-lang" % "scala-reflect" % "2.10.0",
  "mysql" % "mysql-connector-java" % "5.1.26", 
  "org.scalikejdbc" %% "scalikejdbc"       % "2.0.5",
  "com.h2database"  %  "h2"                % "1.4.180",
  "ch.qos.logback"  %  "logback-classic"   % "1.1.2"
)     

play.Project.playScalaSettings
