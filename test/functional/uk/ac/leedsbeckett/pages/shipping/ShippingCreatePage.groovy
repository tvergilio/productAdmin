package uk.ac.leedsbeckett.pages.shipping

import geb.Module
import geb.Page

class ShippingCreatePage extends Page {

    static url = "shipping#/create"

    static at = { $('h2').text() == 'Create Shipping' }

    static content = { 
		nameField {$("input[ng-model='ctrl.shipping.name']")}
		enabledField {$("input[ng-model='ctrl.shipping.enabled']")}
		costField {$("input[ng-model='ctrl.shipping.cost']")}
        saveButton { $('button[crud-button="save"]') }
    }

}