package org.myproject.concatenate;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {

    public static void main(String[] args) {

        String sonnet = "From fairest creatures we desire increase,\n" +
                "That thereby beauty's rose might never die,\n" +
                "But as the riper should by time decease\n" +
                "His tender heir might bear his memory:\n" +
                "But thou, contracted to thine own bright eyes,\n" +
                "Feed'st thy light's flame with self-substantial fuel,\n" +
                "aking a famine where abundance lies,\n" +
                "Thyself thy foe, to thy sweet self too cruel.\n" +
                "Thou that art now the world's fresh ornament,\n" +
                "And only herald to the gaudy spring,\n" +
                "Within thine own bud buriest thy content,\n" +
                "And, tender churl, mak'st waste in niggardly.\n" +
                "Pity the world, or else this glutton be,\n" +
                "To eat the world's due, by the grave and thee.";

        String ponnet = """
                From fairest creatures we desire increase,
                That thereby beauty's rose might never die,
                But as the riper should by time decease
                His tender heir might bear his memory:
                But thou, contracted to thine own bright eyes,
                Feed'st thy light's flame with self-substantial fuel,
                Making a famine where abundance lies,
                Thyself thy foe, to thy sweet self too cruel.
                Thou that art now the world's fresh ornament,
                And only herald to the gaudy spring,
                Within thine own bud buriest thy content,
                And, tender churl, mak'st waste in niggardly.
                Pity the world, or else this glutton be,
                To eat the world's due, by the grave and thee.
                    """;

        System.out.println(sonnet);
        System.out.println("====================================================================================");
        System.out.println("====================================================================================");
        System.out.println(ponnet);

        Pattern pattern = Pattern.compile("\\bflame\\b");
        Matcher matcher = pattern.matcher(ponnet);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(group + " " + start + " " + end);
        }

        new PatternMatching().print(ponnet);
    }

    public void print(Object o) {
        System.out.println(o);
        if (!(o instanceof String)) {

            return;
        }
        // String s = "\b\bflame\b\b";
        if (o instanceof String s) {
            System.out.println("the length of the pattern -" + s.length());

            System.out.println(s);
        }
        String formatted = null;
        if (o instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (o instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (o instanceof Double d) {
            formatted = String.format("double %f", d);
        } else {
            formatted = String.format("Object %s", o.toString());
        }

        if (o instanceof String s && !s.isEmpty()) {
            int length = s.length();
            System.out.println("This object is a non-empty string of length " + length);
        }
        String formatter = switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case Object obj -> String.format("Object %s", obj.toString());
        };
    }

    public void writeList() /* throws IOException */ {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < 10; i++) {
                out.println("Value at: " + i + " = " + i);
            }
        } catch (Exception ex) {
            StackTraceElement[] elements = ex.getStackTrace();
            for (StackTraceElement elem : elements) {
                System.err
                        .println(elem.getFileName() + ": " + elem.getLineNumber() + ">>" + elem.getMethodName() + "()");
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }

        try {
            Handler handler = new FileHandler("OutFile.log");
            Logger.getLogger("").addHandler(handler);

        } catch (IOException e) {
            Logger logger = Logger.getLogger("package.name");
            StackTraceElement elements[] = e.getStackTrace();
            for (int i = 0, n = elements.length; i < n; i++) {
                logger.log(Level.WARNING, elements[i].getMethodName());
            }
        }
    }
}
