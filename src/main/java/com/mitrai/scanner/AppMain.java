package com.mitrai.scanner;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class AppMain {

    public static String method1ScriptName = "text_clean_resize.sh";
    public static String method2ScriptName = "thresh_sharp.sh";
    public static String method3ScriptName = "fill_sharp_clean.sh";

    public static void main(String[] args) throws IOException, InterruptedException {
//        FileUtils.deleteDirectory(new File(FileHelper.baseFolder));
        // Initiate all the folders for batch processing
        FileHelper.initBaseFolder();
        File[] listOfFiles = FileHelper.getAllFileNames();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String fileName = listOfFiles[i].getName();
                // check if it is a valid input
                String extensionName = FileHelper.getFileExtension(listOfFiles[i]);
                System.out.println("extension name is " + extensionName);
                if (extensionName.equalsIgnoreCase("jpeg") || extensionName.equalsIgnoreCase("jpg") || extensionName.equalsIgnoreCase("png")) {
//                    TesseractEngine.TerminalImplementation(TesseractEngine.getCommandForTesseract(fileName, method1ScriptName));
//                    TesseractEngine.TerminalImplementation(TesseractEngine.getCommandForTesseract(fileName, method2ScriptName));
//                    TesseractEngine.TerminalImplementation(TesseractEngine.getCommandForTesseract(fileName, method3ScriptName));

                    // read all text
                    System.out.println("remove _ extension" + FileHelper.getFileNameWithoutExtension(listOfFiles[i]));
                    String[] result1 = FileHelper.readFile(FileHelper.resultsFolderPath + FilenameUtils.removeExtension(fileName) + "_1");
                    String[] result2 = FileHelper.readFile(FileHelper.resultsFolderPath + FilenameUtils.removeExtension(fileName) + "_2");
                    String[] result3 = FileHelper.readFile(FileHelper.resultsFolderPath + FilenameUtils.removeExtension(fileName) + "_3");

                    // get all super market template names
                    Properties properties = Configs.getConfigs(Configs.SUPER_MARKET_TEMPLATE_NAME);

                    String templateName = properties.getProperty("tesco_template_name");
                    for (String r : result1) {
                        if ((templateName.length() * 2) <= r.length()) {
                            StringHelper.distance(templateName, r.toLowerCase());
                        }

                        // record the best results
                    }


                    // process receipt for restaurant name

                    // process receipt for line items

                    // process receipt for date




                }
            }
        }
    }
}
