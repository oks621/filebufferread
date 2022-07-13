package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWithBuffer {
    public void writeFile() {
        File file = new File("file.txt");
        try (FileWriter writer = new FileWriter(file)) {
            String text = "987-123-4567\n" +
                    "123 456 7890\n" +
                    "(123) 456-7890";
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFile() {
        try (FileReader reader = new FileReader("file.txt")) {
            BufferedReader readerbuf = new BufferedReader(reader);
            String line = readerbuf.readLine();
            Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- ]?\\d{3}[-]\\d{4}$");
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(matcher.group());
                }
                line = readerbuf.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


