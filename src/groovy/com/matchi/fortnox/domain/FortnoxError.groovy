package com.matchi.fortnox.domain

import com.thoughtworks.xstream.annotations.XStreamAlias

/**

 <error>
    <code>10</code>
    <message>ogiltigt bokf?rings?r</message>
    <messageeng>invalid financial year</messageeng>
 </error>

 <error>
    <code>1002</code>
    <message>Alla f?lten validerades inte.</message>
    <value>
        <edate>required value missing</edate>
    </value>
 </error>

 */
@XStreamAlias("error")
class FortnoxError {
    String code
    String message
    String reponseXml
    String requestUrl
    String requestBody
}
