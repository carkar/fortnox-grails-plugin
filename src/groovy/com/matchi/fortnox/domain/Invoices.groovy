package com.matchi.fortnox.domain

import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamImplicit

@XStreamAlias("invoices")
class Invoices implements Serializable {
    @XStreamImplicit(itemFieldName="invoice")
    List<Invoice> invoices
}
