package filework;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileWorker {

    public FileWorker() {

    }

    public void writeFile(String fileData, String path, boolean append) {

        try(FileWriter writer = new FileWriter(path, append))
        {
            writer.write(fileData);
            writer.flush();

            System.out.println("Maps added!");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public StringBuilder readFile(String path) {
        StringBuilder fileData = new StringBuilder();

        try(FileReader reader = new FileReader(path)) {
            int c;

            while((c=reader.read())!=-1){
                fileData.append((char)c);
            }

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        return fileData;
    }

    public List<String> getMapList(String path) {
        List<String> mapList = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for(int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
            mapList.add(listOfFiles[i].getName());
        }

        return mapList;
    }
}
