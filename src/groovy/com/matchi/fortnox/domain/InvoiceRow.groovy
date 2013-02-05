package com.matchi.fortnox.domain

import com.thoughtworks.xstream.annotations.XStreamAlias

@XStreamAlias("invoicerow")
class InvoiceRow {
    String id
    String descr
    String prodno
    String unit
    Float amount

    Float vat
    Float price
    Float price_inc_vat
    Float row_total
    Float discount
    Float discount_inc_vat

    @Override
    public String toString() {
        return "InvoiceRow{" +
                "amount=" + amount +
                ", id='" + id + '\'' +
                ", descr='" + descr + '\'' +
                ", prodno='" + prodno + '\'' +
                '}';
    }
}
