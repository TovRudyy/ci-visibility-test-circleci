package com.datadog.ci.gradle;

public class GradleStringJoiner {

    public static String join(String delimeter, String... tokens) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            if (i > 0) {
                sb.append(delimeter);
            }
            sb.append(tokens[i]);
        }
        return sb.toString();
    }

}
