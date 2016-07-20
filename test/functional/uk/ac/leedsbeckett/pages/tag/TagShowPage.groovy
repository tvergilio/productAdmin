package uk.ac.leedsbeckett.pages.tag

import geb.Page

class TagShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Tag' }

    static content = {
        successMessage { $(".alert-success") }
    }

}