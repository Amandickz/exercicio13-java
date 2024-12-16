import classes.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String path = null;
        String lineBr = null;

        /*String[] lines = new String[] { "TV LED,1290.99,1",
                "Video Game Chair,350.50,3",
                "Iphone X,900.00,2",
                "Samsung Galaxy 9,850.00,2"};

        path = "C:\\Users\\Amanda\\Desktop\\exe13_java\\vendidos.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for(String line : lines) {
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e){
            e.printStackTrace();
        }*/

        System.out.print("Digite o endereço do arquivo a ser lido: ");
        path = scan.nextLine();

        ArrayList<Product> productList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            do {

                lineBr = br.readLine();
                System.out.println(lineBr);

                String[] split = lineBr.split(",");

                System.out.println(split);

                int cont = 0;
                double valorTotal = 0.0;
                String productName = "";

                for(String s : split) {
                    if(cont == 0){
                        productName = s;
                    } else if(cont == 1){
                        valorTotal = Double.parseDouble(s);
                    } else if(cont == 2){
                        valorTotal *= valorTotal + Double.parseDouble(s);
                    }
                    cont++;
                }

                Product p = new Product(productName, valorTotal);

                productList.add(p);

            } while(lineBr != null);

        } catch (IOException e){
            e.printStackTrace();
        } catch (NullPointerException e) {

            path = "C:\\Users\\Amanda\\Desktop\\exe13_java\\out\\summary.csv";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

                for(Product p : productList) {
                    bw.write(p.toString());
                    bw.newLine();
                }

            } catch (IOException x){
                x.printStackTrace();
            }
            scan.close();
        }



        //C:\Users\Amanda\Desktop\exe13_java

    }
}