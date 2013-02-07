package com.matchi.fortnox.services

import com.matchi.fortnox.FortnoxException
import com.matchi.fortnox.domain.FortnoxError
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

class FortnoxService {

    static final def BASE_URL = "https://api.fortnox.se/ext/"

    def xmlHelper
    def grailsApplication

    def doPost(def path, def auth, def bodyParams, Closure closure) {

        def httpUrl = appendAuthParameters("${BASE_URL}${path}", auth)

        def builder = new HTTPBuilder(httpUrl)
        builder.encoder.setCharset("UTF-8")

        builder.request( Method.POST, ContentType.TEXT ) {
            requestContentType = ContentType.URLENC
            send ContentType.URLENC, bodyParams

            response.failure = { resp ->
                throw new IllegalStateException("FortnoxError from fortnox")
            }

            response.success = { resp, xmlData ->
                def xml = xmlData.getText()
                def object = xmlHelper.fromXML(xml)

                validateResponse(object, xml, httpUrl)

                closure.call(object)
            }
        }

    }

    def doGet(def path, def auth, def params = [:], Closure closure) {

        def httpUrl = appendAuthParameters("${BASE_URL}${path}", auth)
        httpUrl += "&${queryParameters(params)}"

        new HTTPBuilder( httpUrl ).request( Method.GET, ContentType.TEXT ) {
            requestContentType = 'application/x-www-form-urlencoded; charset=utf-8'

            response.failure = { resp ->
                throw new IllegalStateException("FortnoxError from fortnox")
            }

            response.success = { resp, xmlData ->
                def xml = xmlData.getText()
                def objects = xmlHelper.fromXML(xml)

                validateResponse(objects, xml, httpUrl)

                closure.call(objects)
            }
        }

    }

    private void validateResponse(def object, result, httpUrl) {
        def bodyParams
        log.info("Incoming " + result)
        log.info("Object " + object)
        if (object instanceof FortnoxError) {
            log.error(result)
            ((FortnoxError) object).reponseXml = result
            ((FortnoxError) object).requestBody = bodyParams
            ((FortnoxError) object).requestUrl = httpUrl
            throw new FortnoxException("FortnoxError: ${httpUrl}", object)
        }
    }

    private def queryParameters(params) {
        def queryParams = params.collect { k, v -> "$k=$v" }.join('&')
        queryParams
    }

    private def appendAuthParameters(url, auth) {
        def authParams = "db=${auth.db}&token=${auth.token}"
        return "${url}?${authParams}"
    }

    public def getBaseUrl() {
        if (grailsApplication.config.grails?.plugins?.fortnox?.baseUrl) {
            return grailsApplication.config.grails?.plugins?.fortnox?.baseUrl
        } else {
            return BASE_URL
        }
    }
}
