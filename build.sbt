organization := "wabisabi"

name := "wabisabi"

version := "2.1.2"

scalaVersion := "2.11.6"

crossScalaVersions := Seq("2.10.4", "2.11.6")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Yrangepos")

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "net.databinder.dispatch" %% "dispatch-core"  % "0.11.2",
  "org.clapper"       %% "grizzled-slf4j"       % "1.0.2",
  "com.netaporter"    %% "scala-uri"            % "0.4.3",
  "org.specs2"        %% "specs2"               % "2.4.15"  % "test",
  "org.slf4j"         % "slf4j-simple"          % "1.7.9"   % "test",
  "org.elasticsearch" % "elasticsearch"         % "1.5.0"   % "test",
  "io.argonaut"       %% "argonaut"             % "6.1"  % "test"
)

// This is intended to remove the noise generated by loads of log entries outputted to console
// by Elasticsearch embedded server when running the tests
testOptions in Test ++= Seq(
  Tests.Setup( () => System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "warn"))
)

publishTo := Some(Resolver.file("file",  new File( "/Users/gphat/src/mvn-repo/releases" )) )

