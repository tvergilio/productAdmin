package uk.ac.leedsbeckett.pages.image

import geb.Module
import geb.Page

class ImageCreatePage extends Page {

    static url = "image#/create"

    static at = { $('h2').text() == 'Create Image' }

    static content = { 

        saveButton { $('button[crud-button="save"]') }
    }

}