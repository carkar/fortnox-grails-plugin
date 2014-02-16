package com.matchi.fortnox.domain

import com.thoughtworks.xstream.annotations.XStreamAlias

@XStreamAlias("contact")
class Contact implements Serializable {

    /** identifier */
    String id

    /** contact name (surname and lastname if person) */
    String name

    /** Customer type 1=Company, 2=Private */
    String custtype

    /** Contact address */
    String address
    String address2
    String visitaddress
    String zip
    String city
    String country

    /** Contact comment */
    String comment

    /** Customer number */
    String custno
    String orgno

    /** Contact information */
    String phone
    String fax
    String email
    String www
    String phone2

    /** VAT number */
    String vatno

    /** Delivery address */
    String delname
    String deladdress
    String deladdress2
    String delvisitaddress
    String delzip
    String delcity
    String delcountry
    String delphone
    String delphone2
    String delfax

    /** Email */
    @XStreamAlias("email_offer")
    String email_offer

    @XStreamAlias("email_order")
    String email_order

    @XStreamAlias("email_invoice")
    String email_invoice

    String yourref
    String ourref


    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", custno='" + custno + '\'' +
                '}';
    }
}
