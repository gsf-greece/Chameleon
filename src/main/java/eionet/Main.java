package eionet;

import eionet.converters.ConvertException;
import eionet.converters.Converter;
import eionet.converters.CustomConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * @author George Sofianos
 *
 */
public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Converter converter;
        //if (args[3] == "old") {
        //    SjConverter conv = new SjConverter();
        //    String[] ar = {"net.ucanaccess.jdbc.UcanaccessDriver", "jdbc:ucanaccess://" + args[0], "n", "n", args[1], "--batch", "all", "--ignore-nodata"};
        //    conv.nonStaticMain(ar);
        // }
        if (args.length == 2) {
            converter = new CustomConverter();
            converter.setDriver("net.ucanaccess.jdbc.UcanaccessDriver");
            converter.setUrl("jdbc:ucanaccess://" + args[0]);
            converter.setInput(args[1]);
            try {
                converter.convert();
            } catch(ConvertException ex) {
                log.error("An error occured while executing sql statements: " + ex);
                System.exit(1);
            } catch (SQLException ex) {
                log.error("An error occured while executing sql statements: " + ex);
                System.exit(2);
            }
        } else {
            log.error("Wrong arguments");
        }
    }
}