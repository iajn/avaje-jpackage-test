package fi.iajn.jpackagetest;

import io.avaje.inject.BeanScope;

public class Main {

    public static void main(String[] args) {
        try (BeanScope scope = BeanScope.builder()
                .build()) {
            TestType testType = scope.get(TestType.class);
            testType.test();
        }
    }

}
