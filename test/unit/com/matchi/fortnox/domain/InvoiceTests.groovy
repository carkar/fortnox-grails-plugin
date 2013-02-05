package com.matchi.fortnox.domain

import com.thoughtworks.xstream.XStream
import org.junit.Before
import org.junit.Test

class InvoiceTests  {

    def xstream

    @Before
    public void setUp() {
        xstream = new XStream()
        xstream.processAnnotations(Invoice.class)
    }

    @Test
    public void test() {
    }

    static def xml = """
        <?xml version="1.0" encoding="UTF-8" ?>
        <invoice>
            <id>10</id>
            <admfee>10</admfee>
            <ddate>2007-03-26</ddate>
            <dbcreated>spec</dbcreated>
            <delcond>FVL</delcond>
            <deltype>P</deltype>
            <edate>2007-03-29</edate>
            <freight>123</freight>
            <orderno>1234</orderno>
            <ourref>Vår referens</ourref>
            <paycond>N41</paycond>
            <paypend>0</paypend>
            <printed>0</printed>
            <remark>Fakturatexten</remark>
            <roundoff>0.5</roundoff>
            <tdate>2007-03-26</tdate>
            <total>250</total>
            <totalvat>50</totalvat>
            <parts>0</parts>
            <type>F</type>
            <yourref>Er referens</yourref>
            <contact>
            <id>1</id>
            <address>gatan 10</address> <address2>gatan 12</address2> <city>Uppsala</city>
            <comment>ett bra företag</comment>
            <country>SE</country>
            <deladdress></deladdress>
            <deladdress2></deladdress2>
            <delcity></delcity>
            <delcountry></delcountry>
            <delfax></delfax>
            <delname></delname>
            <delphone></delphone>
            <delphone2></delphone2>
            <delvisitaddress></delvisitaddress>
            <delzip></delzip>
            <email>e@mail.com</email> <fax></fax>
            <name>Företag AB</name>
            <orgno>12345</orgno>
            <ourref>Kalle</ourref>
            <paycond>30</paycond>
            <delcond>FVL</delcond>
            <deltype>P</deltype>
            <pg>Pg</pg>
            <bg>5083-6527</bg>
            <phone>0470-123456</phone>
            <phone2></phone2>
            <pricelist>A</pricelist>
            <vatno>123456</vatno>
            <visitaddress></visitaddress>
            <www></www>
            <yourref></yourref>
            <zip></zip>
            </contact>
                <invoicerows>
                    <invoicerow>
                        <prodno>10702</prodno>
                        <descr>Fortnox Säljstöd kvartalsabonnemang</descr> <unit>st</unit>
                        <amount>1</amount>
                        <price>207</price>
                        <discount>0</discount> <discounttype>1</discounttype>
                        <acct>3011</acct>
                        <vat>25</vat>
                        <cc></cc>
                    </invoicerow>
                </invoicerows>
        </invoice>
"""

}
