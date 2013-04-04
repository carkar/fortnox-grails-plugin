package com.matchi.fortnox.services

import com.matchi.fortnox.domain.Invoice

class FortnoxInvoiceService {

    private static final String SET_INVOICE         = "set_invoice.php"
    private static final String SET_INVOICE_CANCEL  = "set_invoice_cancel.php"
    private static final String GET_INVOICES        = "get_invoices.php"
    private static final String GET_INVOICE         = "get_invoice.php"

    def fortnoxService
    def xmlHelper

    def set(Invoice invoice, def auth) {
        def result
        def xml = xmlHelper.toXML(invoice)

        fortnoxService.doPost(SET_INVOICE +".php", auth, [xml:xml]) { res ->
            result = res
        }
        result
    }

    def list(def auth, def filter = "") {
        def result = []
        fortnoxService.doGet(GET_INVOICES, auth, [filter:filter]) { invoices ->
            result = invoices.invoices
        }
        result
    }

    def get(def auth, def id) {
        def result
        fortnoxService.doGet(GET_INVOICE, auth, [id:id]) { invoice ->
            result = invoice
        }
        result
    }

    def cancel(def auth, def id) {
        def result
        fortnoxService.doGet(SET_INVOICE_CANCEL, auth, [id:id]) { invoice ->
            result = invoice
        }
        result
    }
}
