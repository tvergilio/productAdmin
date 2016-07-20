package uk.ac.leedsbeckett.pages.variation

import geb.Module
import geb.Page

class VariationEditPage extends Page {

    static url = "variation#/create"

    static at = { $('h2').text() == 'Edit Variation' }

    static content = {
		descriptionField {$("input[ng-model='ctrl.variation.description']")}
		imageField {$("select[ng-model='ctrl.variation.image']")}
		regularPriceField {$("input[ng-model='ctrl.variation.regularPrice']")}
		salePriceField {$("input[ng-model='ctrl.variation.salePrice']")}
		shippingField {$("select[ng-model='ctrl.variation.shipping']")}
        saveButton { $('button[crud-button="save"]') }
    }

}