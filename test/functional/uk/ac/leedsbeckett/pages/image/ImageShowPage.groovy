package uk.ac.leedsbeckett.pages.image

import geb.Page

class ImageShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Image' }

    static content = {
        successMessage { $(".alert-success") }
    }

}