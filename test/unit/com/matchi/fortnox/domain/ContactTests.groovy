package com.matchi.fortnox.domain

import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.xml.DomDriver
import com.thoughtworks.xstream.mapper.MapperWrapper
import org.junit.Before
import org.junit.Test


class ContactTests {

    def xstream

    @Before
    public void setUp() {
        xstream = new XStream(new DomDriver()) {
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
        xstream.processAnnotations(Contacts.class)
        xstream.processAnnotations(Contact.class)

    }

    @Test
    public void testToXml() {
        Contacts contacts = new Contacts()
        contacts.contacts = [new Contact(id: 1)]

        println xstream.toXML(contacts)
    }

    @Test
    public void fromXml() {
        def xml = """
<contacts>
  <contact>
    <id>1</id>
    <awd>1</awd>
  </contact>
</contacts>
            """

        Contacts contacts = xstream.fromXML(xml)

        assert contacts.contacts.size() == 1

    }
}
