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
    }
    private static void initialize() {
        port(8080);
        staticFiles.location("/public");
        thredPool(8, 2, 30000);
    }
}
