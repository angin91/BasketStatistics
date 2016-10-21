package se.kungsbacka.basket;

import se.kungsbacka.basket.imports.ReadExcel;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.start();
    }
    
    public void start(){
    	ReadExcel readExcel = new ReadExcel();
    	readExcel.readExcel("files/test.xlsx");
    }
}
