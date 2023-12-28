import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void  copyFile(String sourcePath, String outputPath) {
        try {
            File source = new File(sourcePath);
            File output = new File(outputPath);

            if (!source.exists())
                throw new FileNotFoundException();
            if (output.exists())
                System.out.println("File already exists");

            BufferedReader br = new BufferedReader(new FileReader(source));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));

            int line;
            while ((line = br.read())!=-1){
                System.out.print((char)line);
                bw.write((char)line);
            }
            br.close();
            bw.close();
        }catch (Exception e) {
            System.err.println("File not found or invalid content!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter source path: ");
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        System.out.println("Enter output path: ");
        String output = scanner.nextLine();

        copyFile(source, output);
    }
}
