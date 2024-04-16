package run;

import domPars.ParserDom;
import saxPars.ParserSax;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws IOException {

        File file = new File("body.xml");

        System.out.println("Enter 1 or 2. If you'll choose 1, the program will use DOM parser. If you'll choose 2 - SAX parser");
        Scanner scanner = new Scanner(System.in);
        int numb = scanner.nextInt();
        if (numb == 1) {
            ParserDom parserDoc = new ParserDom();
            parserDoc.DomParser(file);
        } else if (numb == 2) {
            ParserSax parser = new ParserSax();
            parser.SaXParser(file);
        } else {
            System.out.println("Wrong number or symbol. Try again ");
        }
    }
}
