package main.java;

import java.io.*;

public class FileWithBuffer {
    public  void writeFile() {
        File file = new File("file.txt");
        try (FileWriter writer = new FileWriter(file))
        {
            String text = "987-123-4567\n" +
                    "123 456 7890\n" +
                    "(123) 456-7890";
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public  void readFile() {
        try (FileReader reader = new FileReader("file.txt")) {
            BufferedReader readerbuf = new BufferedReader(reader);
            String line = readerbuf.readLine();
            while (line != null) {
                if(line.contains("-"))
                System.out.println(line);

                line = readerbuf.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
