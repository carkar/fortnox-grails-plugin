package com.matchi.fortnox.utils

import com.matchi.fortnox.domain.Contact
import com.matchi.fortnox.domain.Contacts
import com.matchi.fortnox.domain.FortnoxError
import com.matchi.fortnox.domain.Invoice
import com.matchi.fortnox.domain.InvoiceRow
import com.matchi.fortnox.domain.Invoices
import com.matchi.fortnox.domain.Item
import com.matchi.fortnox.domain.Items
import com.matchi.fortnox.domain.Result
import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.xml.DomDriver
import com.thoughtworks.xstream.mapper.MapperWrapper

/**
 * Created with IntelliJ IDEA.
 * User: calle
 * Date: 12/16/12
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
class XmlHelper {

    XStream xstream

    XmlHelper() {
        xstream = new XStream(new DomDriver()) {
            /*
                Do not REQUIRE all field to be present in target object
             */
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(Class definedIn,
                                                         String fieldName) {
                        if (definedIn == Object.class) {
                            return false;
                        }
                        return super.shouldSerializeMember(definedIn, fieldName);
                    }
                };
            }
        };

        xstream.processAnnotations(Contact.class)
        xstream.processAnnotations(Contacts.class)
        xstream.processAnnotations(Invoice.class)
        xstream.processAnnotations(Invoices.class)
        xstream.processAnnotations(InvoiceRow.class)
        xstream.processAnnotations(Item.class)
        xstream.processAnnotations(Items.class)
        xstream.processAnnotations(FortnoxError.class)
        xstream.processAnnotations(Result.class)
        xstream.registerConverter(new PriceConverter())
    }

    def fromXML(String xml) {
        xstream.fromXML(xml)
    }

    def toXML(def object) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(outputStream, "UTF-8");

        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        xstream.toXML(object, writer);
        return outputStream.toString("UTF-8");

    }

}
