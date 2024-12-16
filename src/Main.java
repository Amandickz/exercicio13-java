import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] lines = new String[] { "TV LED,1290.99,1",
                "Video Game Chair,350.50,3",
                "Iphone X,900.00,2",
                "Samsung Galaxy 9,850.00,2"};

        String path = "C:\\Users\\Amanda\\Desktop\\exe13_java\\in.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for(String line : lines) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();

            while(line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException e){
            e.printStackTrace();
        }



        //C:\Users\Amanda\Desktop\exe13_java

    }
}