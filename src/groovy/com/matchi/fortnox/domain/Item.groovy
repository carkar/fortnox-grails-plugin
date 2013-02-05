package com.matchi.fortnox.domain

import com.matchi.fortnox.utils.PriceConverter
import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamConverter

@XStreamAlias("item")
class Item {
    String id
    String descr
    String type
    String unit

    @XStreamConverter(PriceConverter.class)
    Price price
}
