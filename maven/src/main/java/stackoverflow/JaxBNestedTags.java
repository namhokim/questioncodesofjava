package stackoverflow;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class JaxBNestedTags {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader("<customer id=\"100\"><age>29</age> <name>myname<b>abcd</b>123</name></customer>");
            Customer customer1 = (Customer) unmarshaller.unmarshal(reader);

            System.out.println(customer1);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
