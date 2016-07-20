package uk.ac.leedsbeckett.pages.feature

import geb.Page

class FeatureShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Feature' }

    static content = {
        successMessage { $(".alert-success") }
    }

}