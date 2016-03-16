package eionet.converters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author George Sofianos
 */
public interface Converter {

    void convert() throws ConvertException, SQLException;

    void setDriver(String s);

    void setUrl(String s);

    void setInput(String arg);

}
