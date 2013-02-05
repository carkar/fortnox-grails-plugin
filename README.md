fortnox-grails-plugin
=====================

Summary
-------
This plugin interfaces against [Fortnox API](http://www.fortnox.se). It's a work in progress but currently support creation and reading of: `Invoice`, `Contact` and `Item`.

All communcation with API is done through: `FortnoxInvoiceService`, `FortnoxItemService`, `FortnoxContactService`. Inject theses services in taglibs, controllers or services.

Please also see the [GUI application for this plugin](https://github.com/carkar/fortnox-grails-plugin-ui)

Installation
------------
`grails package-plugin`

Results in a grails-fortnox-X.X.zip, then in grails web application:

`grails install-plugin /path/to/grails-fortnox.zip`

Configuration
-------------

The API base url is configures through `grails.plugins.fortnox.baseUrl`. If not provided the default value `https://api.fortnox.se/ext/` is used.

