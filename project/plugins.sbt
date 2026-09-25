// The Play plugin
// Plugin chính của Play Framework 3.0
addSbtPlugin("org.playframework" % "sbt-plugin" % "3.0.11")

// Plugin hỗ trợ Eclipse
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")

// Defines scaffolding (found under .g8 folder)
// http://www.foundweekends.org/giter8/scaffolding.html
// sbt "g8Scaffold form"
addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8-scaffold" % "0.18.0")
