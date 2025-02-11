module jpackage.test {
    requires io.avaje.inject;

    provides io.avaje.inject.spi.InjectExtension with fi.iajn.jpackagetest.JpackagetestModule;
}
