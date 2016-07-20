package uk.ac.leedsbeckett.pages.product

import geb.Page

class ProductShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Product' }

    static content = {
        successMessage { $(".alert-success") }
    }

}