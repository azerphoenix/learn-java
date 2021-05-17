package info.md7.java.lessons.other;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesStream {

    public static void main(String[] args) throws IOException {

        List<String> lines;
        Path path = Paths.get("/home/phoenix/Desktop/blabla.txt");
        Stream<String> lineStream = Files.lines(path);
        lines = lineStream.collect(Collectors.toList());
        System.out.println(lines);


    }

}
