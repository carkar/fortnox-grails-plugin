package com.matchi.fortnox.domain

import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamImplicit

@XStreamAlias("items")
class Items {
    @XStreamImplicit(itemFieldName="item")
    List<Item> items
}
