package uk.ac.leedsbeckett.pages.image

import geb.Module
import geb.Page

class ImageEditPage extends Page {

    static url = "image#/create"

    static at = { $('h2').text() == 'Edit Image' }

    static content = {

        saveButton { $('button[crud-button="save"]') }
    }

}