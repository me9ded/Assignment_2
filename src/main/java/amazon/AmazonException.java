/*
 * Students Names: Fouzi Haidar & Mohamed Amine Jmal
 * Student Number: 041157806 &     041138938
 * Professor Name: Paulo Sousa
 * Assignment 2
 * Description: Read the CSV, create proper classes, exception
handling, packages as well as perform operations using Collections (ArrayList), that
includes inclusion, edition, deletion and searching.*/
package amazon;
public class AmazonException extends Exception{
    private static final long serialVersionUID = 1698167943665186196L;

    public AmazonException(String errorMessage){
        super(errorMessage);
        System.err.println("AmazonProductException: " + errorMessage);
    }
}