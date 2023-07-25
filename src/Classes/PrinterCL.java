package Classes;

import Interfaces.Printable;

public class PrinterCL implements Printable {
    public void print(String message){
        System.out.print(message);
    }

    public void println(String message){
        System.out.println(message);
    }
}
