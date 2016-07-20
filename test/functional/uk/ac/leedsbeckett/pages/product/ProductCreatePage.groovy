package uk.ac.leedsbeckett.pages.product

import geb.Module
import geb.Page

class ProductCreatePage extends Page {

    static url = "product#/create"

    static at = { $('h2').text() == 'Create Product' }

    static content = { 
		nameField {$("input[ng-model='ctrl.product.name']")}
		descriptionField {$("input[ng-model='ctrl.product.description']")}
		longDescriptionField {$("input[ng-model='ctrl.product.longDescription']")}
		regularPriceField {$("input[ng-model='ctrl.product.regularPrice']")}
		salesPriceField {$("input[ng-model='ctrl.product.salesPrice']")}
		shippingField {$("select[ng-model='ctrl.product.shipping']")}
        saveButton { $('button[crud-button="save"]') }
    }

}