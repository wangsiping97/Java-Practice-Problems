package datachooser;

import java.io.BufferedReader;    
import java.io.FileReader; 
import java.io.BufferedWriter;    
import java.io.File;    
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class DataChooser {
    DataChooser (String input, String output) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        File csv = new File(output);
        BufferedWriter writer = new BufferedWriter(new FileWriter(csv, true));
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] item = line.split(",");
            String department = item[3];
            writer.write(department);
            writer.newLine();
        }
        writer.close();
    }
}