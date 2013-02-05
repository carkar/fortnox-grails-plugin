package com.matchi.fortnox.services

import com.matchi.fortnox.domain.Items

class FortnoxItemService {

    public static final String GET_ITEM = "get_item.php"
    public static final String SET_ITEM = "set_item.php"

    def fortnoxService
    def xmlHelper

    def list(def auth) {
        def items

        fortnoxService.doGet(GET_ITEM, auth, [id:"all"]) { def val ->
            items = val.items
        }
        items
    }

    def set(def item, def auth) {

        def xml = new String(xmlHelper.toXML(item).getBytes("UTF-8"), "UTF-8")

        log.info(xml)

        def id = null

        fortnoxService.doPost(SET_ITEM, auth, [xml:xml]) { def result ->
            log.debug("Item with id ${result.id} set to Fortnox")
            id = result.id
        }
        return id
    }

    def get(def id, def auth) {
        def item
        fortnoxService.doGet(GET_ITEM, auth, [id:id]) { def val ->
            item = val
        }
        item
    }
}
