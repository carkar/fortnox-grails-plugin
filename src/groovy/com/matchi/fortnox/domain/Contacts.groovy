package com.matchi.fortnox.domain

import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamImplicit

@XStreamAlias("contacts")
class Contacts implements Serializable {

    @XStreamImplicit(itemFieldName="contact")
    List<Contact> contacts = new ArrayList<Contact>()
}
