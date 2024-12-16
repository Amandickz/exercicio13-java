import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] lines = new String[] { "TV LED,1290.99,1",
                "Video Game Chair,350.50,3",
                "Iphone X,900.00,2",
                "Samsung Galaxy 9,850.00,2"};

        String path = "C:\\Users\\Amanda\\Desktop\\exe13_java\\vendidos.csv";

        String lineBr = null;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for(String line : lines) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.print("Digite o endereço do arquivo a ser lido: ");
        scan.nextLine();
        path = scan.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            do {

                lineBr = br.readLine();
                System.out.println(lineBr);

                String[] split = lineBr.split(",");

                System.out.println(split);

                int cont = 0;
                double valorTotal = 0.0;

                for(String s : split) {
                    if(cont == 1){
                        valorTotal = Double.parseDouble(s);
                    } else if(cont == 2){
                        valorTotal *= valorTotal + Double.parseDouble(s);
                    }
                    cont++;
                }
            } while(lineBr != null);

        } catch (IOException e){
            e.printStackTrace();
        } catch (NullPointerException e) {
            scan.close();
        }



        //C:\Users\Amanda\Desktop\exe13_java

    }
}