package uk.ac.leedsbeckett.pages.feature

import geb.Module
import geb.Page

class FeatureEditPage extends Page {

    static url = "feature#/create"

    static at = { $('h2').text() == 'Edit Feature' }

    static content = {
		nameField {$("input[ng-model='ctrl.feature.name']")}
        saveButton { $('button[crud-button="save"]') }
    }

}