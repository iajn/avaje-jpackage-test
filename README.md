# avaje-jpackage-test

Sample for an issue I noticed with avaje-inject and jpackage.

Running ```mvn clean package``` builds the code and packages an app-image using jpackage.
The image contains a slimmed runtime with an executable for launching the application.
The only modules included are:

```
JAVA_VERSION="23"
MODULES="java.base io.avaje.applog jakarta.inject io.avaje.inject jpackage.test"
```

Running the application fails though, with the following message:

```
C:\work\avaje-jpackage-test>target\dist\jpackagetest\jpackagetest.exe
Exception in thread "main" java.util.ServiceConfigurationError: io.avaje.inject.spi.InjectExtension: Provider io.avaje.inject.events.spi.ObserverManagerPlugin not found
        at java.base/java.util.ServiceLoader.fail(Unknown Source)
        at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.nextProviderClass(Unknown Source)
        at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.hasNextService(Unknown Source)
        at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.hasNext(Unknown Source)
        at java.base/java.util.ServiceLoader$2.hasNext(Unknown Source)
        at java.base/java.util.ServiceLoader$3.hasNext(Unknown Source)
        at io.avaje.inject@11.2/io.avaje.inject.DServiceLoader.<init>(Unknown Source)
        at io.avaje.inject@11.2/io.avaje.inject.DBeanScopeBuilder.build(Unknown Source)
        at jpackage.test@1.0/fi.iajn.jpackagetest.Main.main(Unknown Source)
Failed to launch JVM
```

Including the module ```io.avaje.inject.events``` with explicitly (see pom.xml, line 101) fixes the issue,
but I don't understand why or how the module ends up being required at runtime.
