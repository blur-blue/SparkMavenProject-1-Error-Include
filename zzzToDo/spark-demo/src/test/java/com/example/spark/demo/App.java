package com.example.spark.demo;

/*
 *
 * spark demo app
 */
public class App 
{
    public static void main( String[] args )
    {
        initialize();
        ToDoApi.api();
        mkfiles();
    }
    private static void initialize() {
        port(8080);
        staticFiles.location("/public");
        thredPool(8, 2, 30000);
    }
    private static void mkfiles() {
        File dir = new File("temp.txt");
        if (dir.exists()) {
            dir.delete();
            dir.delete();    
    }
}
