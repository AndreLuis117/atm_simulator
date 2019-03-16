package tools;

import entity.Account;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class File_tools {
    public long file_size() {
        long aux = 0;
        try {
            File file = new File("C:\\Users\\dante\\Downloads\\contas.txt");
            Path path = Paths.get("C:\\Users\\dante\\Downloads\\contas.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader read = new BufferedReader(fileReader);
            List<String> lines = Files.readAllLines(path);
            aux = lines.size();
        } catch (Exception e){
            e.printStackTrace();
        }

        return aux;
    }


}
