
title: Download
menu-position: 3
---

_This framework is actually in early stage and only available as snapshot_

## SBT

      val sindi = "org.scala-tools.sindi" %% "sindi" % "0.1-SNAPSHOT"

      val aloiscochardSnapshots = "aloiscochard snapshots" at "http://orexio.org/~alois/repositories/snapshots" 

## Maven

    <dependencies>
      ...
      <dependency>
        <groupId>org.scala-tools.sindi</groupId>
        <artifactId>sindi_2.9.0</artifactId>
        <version>0.1-SNAPSHOT</version>
      </dependency>
      ...
    </dependencies>

    <repositories>
      ...
      <repository>
        <id>aloiscochard snapshots</id>
        <url>http://orexio.org/~alois/repositories/snapshots</url>
      </repository>
      ...
    </repositories>