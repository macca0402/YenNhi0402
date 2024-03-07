package SS10.demo.MVC.ReadWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static void writeFile(String src, String value, boolean append) {
        File file = new File(src);
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(value);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file");
            }
        }
    }

    public static List<String> readFile(String src) {
        List<String> strings = new ArrayList<>();
        File file = new File(src);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File khong ton tai");
        } catch(IOException e) {
            System.out.println("Lỗi đọc file");
        } finally {
            try{
                bufferedReader.close();
            } catch(IOException e){
                System.out.println("Lỗi đóng file.");
            }

        }
        return strings;
    }

    public static void main(String[] args) {
        File file=new File("src/SS10/demo/data/test");
        FileWriter fileWriter=null;
        try{
            fileWriter =new FileWriter(file,true);
            fileWriter.write("A0323I1");
        } catch(IOException e){
            System.out.println("Lỗi ghi file");
        }finally {
            try{
                fileWriter.close();
            } catch(IOException e){
                System.out.println("Lỗi đóng file");
            }
        }
    }
}
