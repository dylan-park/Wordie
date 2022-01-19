import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class Dictionary {
    private final String pathString;

    public Dictionary(String pathString) {
        this.pathString = pathString;
    }

    public long getTotalLineNumbers() {
        Path path = Paths.get(pathString);
        long lines = 0;

        try {
            lines = Files.lines(path).parallel().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public String getWordFromLineNumber(long lineNumber) {
        try (Stream<String> lines = Files.lines(Paths.get(pathString))) {
            Optional<String> word = lines.skip(lineNumber - 1).findFirst();
            return word.orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
