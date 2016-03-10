package eionet;

import eionet.converters.SjConverter;

/**
 * @author George Sofianos
 *
 */
public class Main {
    public static void main(String[] args) {
        SjConverter converter = new SjConverter();
        if (args.length == 2) {
            String[] ar = {"net.ucanaccess.jdbc.UcanaccessDriver", "jdbc:ucanaccess://" + args[0], "n", "n", args[1], "--batch", "all", "--ignore-nodata"};
            converter.nonStaticMain(ar);
        } else {
            System.out.println("Wrong arguments");
        }
    }
}
