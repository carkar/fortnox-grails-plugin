package com.matchi.fortnox.domain

import com.matchi.fortnox.utils.FloatConverter
import com.matchi.fortnox.utils.XmlHelper
import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamConverter

@XStreamAlias("invoice")
class Invoice implements Serializable {

    String id
    String type
    Float admfee

    /* delivery date, required, default: same as tdate */
    String ddate

    /* invoice date, financial year will be selected from this date */
    String tdate

    /* invoice expiration date */
    String edate
    String endpay
    String contact_name
    String remark
    @XStreamConverter(FloatConverter.class)
    Float total
    @XStreamConverter(FloatConverter.class)
    Float totalvat
    @XStreamConverter(FloatConverter.class)
    Float vat
    @XStreamConverter(FloatConverter.class)
    Float saldo
    Contact contact
    String color
    String status
    String comment
    String invoice_last_output

    String modified

    @XStreamAlias("invoicerows")
    List<InvoiceRow> invoicerows = new ArrayList<InvoiceRow>()

}
