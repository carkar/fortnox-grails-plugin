package com.matchi.fortnox.domain

import com.matchi.fortnox.utils.PriceConverter
import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamConverter

@XStreamAlias("item")
class Item implements Serializable {
    String id
    String descr
    String type
    String unit

    @XStreamConverter(PriceConverter.class)
    Price price

    String getFirstPrice() {
        return (price.lists.values().size() > 0 ? price.lists.values().iterator().next() : "0")
    }
}
