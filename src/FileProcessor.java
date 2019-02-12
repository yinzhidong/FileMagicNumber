import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class FileProcessor {

    private List<SingleFormat> formats = new ArrayList<>();
    private File file = null;
    private Scanner scanner = null;
    private String inputMagicByte = null;
    private SingleFormat fileFormat = null;
    boolean hasExtention;

    public  FileProcessor() {
        formats.add(new SingleFormat("jpg", new String[]{"FF","D8","FF","E0","00","10","4A","46","49","46","00","01"} , 0));
        formats.add(new SingleFormat("jpg", new String[]{"FF", "D8", "FF", "DB"} , 0));
        formats.add(new SingleFormat("jpg", new String[]{"FF", "D8", "FF", "EE"} , 0));
        formats.add(new SingleFormat("jpg", new String[]{"FF", "D8", "FF", "E1"} , 0));
        formats.add(new SingleFormat("gif", new String[]{"47", "49", "46", "38", "37", "61"} , 0));
        formats.add(new SingleFormat("gif", new String[]{"47", "49", "46", "38", "39", "61"} , 0));
        formats.add(new SingleFormat("txt", new String[]{"EF", "BB", "BF"} , 0));
    }

    public void processFile() {
        boolean again = true;

            System.out.println("write path to your file: ");
            scanner = new Scanner(System.in);
            file = new File(scanner.nextLine());

            try {
                hasExtention = confirmFileHasExtention(file);
            } catch (ExtentionNotHandledException e) {
                e.printStackTrace();
            }
            if (hasExtention) {
                fileFormat = readFilesMagicNumber();
                if (fileFormat != null)
                    System.out.println(String.format("Your file %s is safe, extention is correct!", fileFormat.getName()));
            }
    }

    public boolean confirmFileHasExtention(File file) throws ExtentionNotHandledException {
        for ( SingleFormat format : formats) {
            if (file.getName().endsWith(format.getName()))
                return true;
        }
        throw new ExtentionNotHandledException("Extention not handled");
    }

    public SingleFormat readFilesMagicNumber() {
        for (SingleFormat format : formats) {
//            if (format.getName() == "txt")
//                return format;
            if (file.getName().endsWith(format.getName())) {
                int read = 0;
                String [] formatMagicByte = format.getMagicNumber();
                try (RandomAccessFile inputStream = new RandomAccessFile(file, "r")) {
                    inputStream.seek(format.getOffset());
                    for(int i = 0; i < formatMagicByte.length; i++) {
                        read = inputStream.read();
                        if (Integer.toHexString(read).length() == 1)
                            inputMagicByte = "0".concat(Integer.toHexString(read).toUpperCase());
                        else inputMagicByte = Integer.toHexString(read).toUpperCase();
                        if (!inputMagicByte.equals(formatMagicByte[i])) {
                            System.out.println("wrong extention!");
                            break;
                        }
                        if (i ==formatMagicByte.length - 1)
                            return format;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
