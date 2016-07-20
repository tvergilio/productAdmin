package uk.ac.leedsbeckett.pages.feature

import geb.Module
import geb.Page

class FeatureCreatePage extends Page {

    static url = "feature#/create"

    static at = { $('h2').text() == 'Create Feature' }

    static content = { 
		nameField {$("input[ng-model='ctrl.feature.name']")}
        saveButton { $('button[crud-button="save"]') }
    }

}