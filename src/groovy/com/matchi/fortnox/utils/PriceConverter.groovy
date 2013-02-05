package com.matchi.fortnox.utils

import com.matchi.fortnox.domain.Price
import com.thoughtworks.xstream.converters.Converter
import com.thoughtworks.xstream.converters.MarshallingContext
import com.thoughtworks.xstream.converters.UnmarshallingContext
import com.thoughtworks.xstream.io.HierarchicalStreamReader
import com.thoughtworks.xstream.io.HierarchicalStreamWriter

class PriceConverter implements Converter {

    @Override
    boolean canConvert(Class aClass) {
        return aClass.isAssignableFrom(Price.class)
    }

    @Override
    void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        if (value.lists) {
            value.lists.each {
                writer.startNode(it.key)
                writer.startNode("from-0")
                writer.setValue(it.value)
                writer.endNode()
                writer.endNode()
            }
        }

    }

    @Override
    Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        def price = new Price()

        while(reader.hasMoreChildren()) {
            reader.moveDown()

            def nodeName = reader.getNodeName()
            reader.moveDown()
            def priceValue = reader.getValue()
            reader.moveUp()

            reader.moveUp()

            price.lists.put(nodeName, priceValue)
        }

        return price
    }

}
