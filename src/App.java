
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {


    public static void main(String [] args) {

        FileProcessor processor = new FileProcessor();

            processor.processFile();

    }
//
//        final String string = "FFD8FFE000104A4649460001";
//        RandomAccessFile inputStream = null;
//        String magicNumber = "";
//        byte [] bytes = new byte[string.length()];
//        int offset;
//        int read;
//        String exst;
//        try{
//            File file = new File("/Users/mateusz/desktop/tcdcdct.txt");
//          //  exst = file.getName().;
//            inputStream = new RandomAccessFile(file, "r");
//
//
//        } catch (FileNotFoundException e) {
//
//        } finally {
//            //inputStream.close();
//        }
//
//
//        try {
//            inputStream.seek(0);
//            while(magicNumber.length() < string.length()){
//                read = inputStream.read();
//                if ( Integer.toHexString(read).length() == 1)
//                    magicNumber = magicNumber.concat("0");
//                magicNumber = magicNumber.concat(Integer.toHexString(read) + "");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//       // if (magicNumber.toUpperCase().startsWith(string))
//            System.out.println(magicNumber);
//
//
//
//
//
//
//
//
//
//
//
//
//
////        Integer liczba;
////        boolean poprawna;
////        poprawna = false;
////
////        System.out.println("podaj liczbe \n");
////
////        while(poprawna == false) {
////            try {
////                Scanner sc = new Scanner(System.in);
////                liczba = sc.nextInt();
////                poprawna = true;
////            } catch (InputMismatchException e) {
////                poprawna = false;
////                System.err.println("Caught IOException: " +  e.getMessage());
////                e.printStackTrace();
////            } finally {
////            }
////        }
//    }
}
