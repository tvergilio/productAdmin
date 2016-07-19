package uk.ac.leedsbeckett.pages.employee

import geb.Page

class EmployeeShowPage extends Page {

    static at = { $('h2').text().startsWith 'Show Employee' }

    static content = {
        successMessage { $(".alert-success") }
    }

}