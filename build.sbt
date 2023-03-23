val scala3Version = "3.3.0-RC3"

organizationName := "Nigel Eke"
organization     := "nigeleke"

val bsd3License = Some(HeaderLicense.BSD3Clause("2023", "Nigel Eke"))

val configVersion    = "1.4.2"
val scalatestVersion = "3.2.11"

lazy val root = project
  .in(file("."))
  .disablePlugins(HeaderPlugin)
  .settings(
    name           := "user",
    publish / skip := true
  )
  .aggregate(core)

lazy val core = project
  .settings(
    name           := "user-core",
    scalaVersion   := scala3Version,
    headerLicense  := bsd3License,
    publish / skip := true,
    libraryDependencies ++= Seq(
      "com.typesafe"   % "config"    % configVersion,
      "org.scalactic" %% "scalactic" % scalatestVersion,
      "org.scalatest" %% "scalatest" % scalatestVersion % "test"
    )
  )
