package uk.ac.leedsbeckett.pages.variation

import geb.Page

class VariationShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Variation' }

    static content = {
        successMessage { $(".alert-success") }
    }

}