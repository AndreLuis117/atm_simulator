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
            Path path = Paths.get("C:\\Users\\dante\\Downloads\\contas.txt");
            File file = new File("C:\\Users\\dante\\Downloads\\contas.txt");

            FileReader fileReader = new FileReader(file);
            BufferedReader read = new BufferedReader(fileReader);
            List<String> lines = Files.readAllLines(path);
            aux = lines.size();
        } catch (Exception e){
            e.printStackTrace();
        }

        return aux;
    }

    public static File accounts_file(){
        File file = new File("C:\\Users\\dante\\Downloads\\contas.txt");
        return  file;
    }


    public static File statement_file(){
        File file = new File("C:\\Users\\dante\\Downloads\\extratos.txt");
        return file;
    }

    public static Path statement_path(){
        Path path = Paths.get("C:\\Users\\dante\\Downloads\\extratos.txt");
        return path;
    }

    public static Path accounts_path(){
        Path path = Paths.get("C:\\Users\\dante\\Downloads\\contas.txt");
        return path;

    }

}
