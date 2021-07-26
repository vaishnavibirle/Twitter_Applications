package com.bridgelabz.selenium.utility;

import com.bridgelabz.selenium.base.BaseClass1;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

public class PDFReader extends BaseClass1 {

    public String pdfRead() {
        try {
            String currentURL = driver.getCurrentUrl();
            System.out.println(currentURL);
            Log.info("Getting Current URL");
            URL url = new URL(currentURL);

            InputStream is = url.openStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
            PDDocument document = null;

            document = PDDocument.load(bufferedInputStream);
            String pdfContent = new PDFTextStripper().getText(document);
            System.out.println(pdfContent);
        }catch (Exception e){
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }
}
