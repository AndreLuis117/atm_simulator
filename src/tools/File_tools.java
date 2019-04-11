package tools;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class File_tools {

    private static String account_path_file = "C:\\Users\\dante\\Downloads\\contas.txt";
    private static String statement_path_file = "C:\\Users\\dante\\Downloads\\extratos.txt";

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
        File file = new File(account_path_file);
        return  file;
    }


    public static File statement_file(){
        File file = new File(statement_path_file);
        return file;
    }

    public static Path statement_path(){
        Path path = Paths.get(statement_path_file);
        return path;
    }

    public static Path accounts_path(){
        Path path = Paths.get(account_path_file);
        return path;

    }

}
