package uk.ac.leedsbeckett.pages.category

import geb.Page

class CategoryShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Category' }

    static content = {
        successMessage { $(".alert-success") }
    }

}