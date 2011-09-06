name := "demo"

version := "0.3"

organization := "org.scala-tools.sindi.examples"

scalaVersion := "2.9.1"

scalacOptions += "-unchecked"

scalacOptions += "-P:sindi:verbose"

crossScalaVersions := Seq("2.9.0-1", "2.9.1")


libraryDependencies += "org.scala-tools.sindi" %% "sindi-core" % "0.3"


resolvers += "Scala-Tools Maven2 Releases Repository" at "http://scala-tools.org/repo-releases"

resolvers += "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"


autoCompilerPlugins := true

addCompilerPlugin("org.scala-tools.sindi" %% "sindi-compiler" % "0.3")
