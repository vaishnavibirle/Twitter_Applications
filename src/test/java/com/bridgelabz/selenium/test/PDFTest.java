package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass1;
import com.bridgelabz.selenium.utility.PDFReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class PDFTest extends BaseClass1 {

    @Test(priority = 6)
    public void pdf_test() throws IOException {
        PDFReader pdfReader = new PDFReader();
        String actualURL = pdfReader.pdfRead();
        String expectedURl = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURl);
        System.out.println("PDF is able to read");
    }
}
