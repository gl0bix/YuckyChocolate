package org.example;

import org.example.chocolateBar.Bar;
import org.example.chocolateBar.ChocolateBarElement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("*******************************************");
        System.out.println("*** Welcome to the Yucky Chocolate Game ***");
        System.out.println("*******************************************");

        Bar bar = new Bar(3,3);

        System.out.println(ChocolateBarElement.CHOCO.getValue());

        bar.print();

        bar.breakHor(1);
        bar.breakVer(1);

        bar.print();

        System.out.println(bar.isOnlySoap());
    }
}
