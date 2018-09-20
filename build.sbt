name := "test_play_ebean_onetomany_fails"
version := "1.0.0"
scalaVersion := "2.12.6"

lazy val test_play_ebean_onetomany_fails = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

libraryDependencies ++= Seq(
  guice,

  "org.jetbrains" % "annotations" % "16.0.3",

  "mysql" % "mysql-connector-java" % "8.0.12",

  "org.hibernate.javax.persistence" % "hibernate-jpa-2.1-api" % "1.0.2.Final"
)

playEbeanModels in Compile := Seq("models.*")
playEbeanDebugLevel := 3

sources in (Compile,doc) := Seq.empty
publishArtifact in (Compile, packageDoc) := false

PlayKeys.externalizeResources := true