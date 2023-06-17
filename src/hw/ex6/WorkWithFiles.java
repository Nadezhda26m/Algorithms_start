package hw.ex6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithFiles {

    public static void createFile(String[] data, String dirName) throws IOException {
        File file = new File(dirName + File.separator + data[0] + ".txt");
        String newData = convertToFileFormat(data);
        StringBuilder sb = new StringBuilder();
        if (file.exists()) sb = getDataFromFile(newData, file);
        sb.append(newData).append("\n");
        try (FileWriter fwrite = new FileWriter(file)) {
            fwrite.write(sb.toString());
        }
    }

    private static StringBuilder getDataFromFile(String newData, File existsFile)
            throws IOException {
        StringBuilder sb = new StringBuilder();
        try (FileReader fread = new FileReader(existsFile);
             BufferedReader reader = new BufferedReader(fread)) {
            String line = reader.readLine();
            while (line != null) {
                if (line.equals(newData))
                    throw new RuntimeException("Эти данные уже были добавлены");
                sb.append(line).append("\n");
                line = reader.readLine();
            }
        }
        return sb;
    }

    private static String convertToFileFormat(String[] data) {
        StringBuilder sb = new StringBuilder();
        for (String item : data) {
            sb.append("<").append(item).append(">");
        }
        return sb.toString();
    }
}
