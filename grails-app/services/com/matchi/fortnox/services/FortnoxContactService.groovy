package com.matchi.fortnox.services

import com.matchi.fortnox.domain.Contact
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

class FortnoxContactService {

    private static final String GET_CUSTOMER_REGISTER = "get_customerregister.php"
    private static final String GET_CONTACT           = "get_contact.php"
    private static final String GET_CONTACT_BY_CUSTNO = "get_contactbycustno.php"
    private static final String SET_CONTACT           = "set_contact.php"

    def fortnoxService
    def xmlHelper

    def set(Contact contact, def auth) {

        if (!contact.id) {
            contact.custno = "getNEXTCUSTNO" // automagically get next cust number for new contact
        }

        def xml = new String(xmlHelper.toXML(contact).getBytes("UTF-8"), "UTF-8")

        def result = null

        fortnoxService.doPost(SET_CONTACT, auth, [xml:xml]) { def response ->
            log.info("Created customer with id ${response.id}")
            result = response
        }
        return result
    }

    def list(def auth) {
        def result = []
        fortnoxService.doGet(GET_CUSTOMER_REGISTER, auth) { def contacts ->
            result = contacts.contacts
        }
        result
    }

    def get(def id, def auth) {
        def result = null
        fortnoxService.doGet(GET_CONTACT, auth, [id: id]) { Contact contact ->
            result = contact
        }
        result
    }

    def getByCustno(def custno, def auth) {
        def result = null
        fortnoxService.doGet(GET_CONTACT_BY_CUSTNO, auth, [id: custno]) { Contact contact ->
            result = contact
        }
        result
    }
}
