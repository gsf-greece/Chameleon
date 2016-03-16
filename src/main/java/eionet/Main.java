package eionet;

import eionet.converters.ConvertException;
import eionet.converters.Converter;
import eionet.converters.CustomConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Properties;

/**
 * @author George Sofianos
 *
 */
public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Converter converter;
        Properties props = System.getProperties();
        int batchSize = Integer.parseInt(props.getProperty("batchSize", "10000"));
        if (args.length == 2) {
            converter = new CustomConverter(batchSize);
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