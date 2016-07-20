package uk.ac.leedsbeckett.pages.tag

import geb.Module
import geb.Page

class TagCreatePage extends Page {

    static url = "tag#/create"

    static at = { $('h2').text() == 'Create Tag' }

    static content = { 
		nameField {$("input[ng-model='ctrl.tag.name']")}
		descriptionField {$("input[ng-model='ctrl.tag.description']")}
        saveButton { $('button[crud-button="save"]') }
    }

}