package uk.ac.leedsbeckett.pages.shipping

import geb.Page

class ShippingShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Shipping' }

    static content = {
        successMessage { $(".alert-success") }
    }

}