package com.matchi.fortnox.utils

import com.matchi.fortnox.domain.Item
import com.matchi.fortnox.domain.Price
import com.thoughtworks.xstream.XStream
import org.junit.Before
import org.junit.Test

class PriceConverterTests {

    private XStream xstream
    private String xml

    @Before
    public void setUp() {

        xml = """<?xml version="1.0"?>
                    <item>
                      <id>100</id>
                      <descr>Medlemskap 1år</descr>
                      <unit>st</unit>
                      <price>
                        <list-a>
                          <from-0>1000</from-0>
                        </list-a>
                        <list-cc>
                          <from-0>699</from-0>
                        </list-cc>
                      </price>
                    </item>"""

        xstream = new XStream()
        xstream.processAnnotations(Price.class)
        xstream.processAnnotations(Item.class)
        xstream.registerConverter(new PriceConverter())
    }

    @Test
    public void testPriceConverterFromXml() {
        Item item = xstream.fromXML(xml)
        Price price = item.price

        assert price.lists.size() == 2
        assert price.lists."list-a" == "1000"
        assert price.lists."list-cc" == "699"
    }

    @Test
    public void testPriceConvertToXml() {

        Item item = new Item(id: 1, price:  new Price(lists: ["list-a":"1000", "list-b":"500"]))

        String xml = xstream.toXML(item)

        assert xml.contains("<list-a>")
        assert xml.contains("<from-0>")
        assert xml.contains("1000")
        assert xml.contains("500")
        assert xml.contains("</from-0>")
        assert xml.contains("</list-a>")
    }

}
