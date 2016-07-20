package uk.ac.leedsbeckett.pages.variation

import geb.Module
import geb.Page

class VariationListPage extends Page {

    static url = "variation"

    static at = { $('h2').text() == 'Variation List' }

    static content = {
		descriptionFilter {$("input[ng-model='ctrl.filter.description']")}
		imageFilter {$("select[ng-model='ctrl.filter.imageId']")}
		regularPriceFilter {$("input[ng-model='ctrl.filter.regularPrice']")}
		salePriceFilter {$("input[ng-model='ctrl.filter.salePrice']")}
		shippingFilter {$("select[ng-model='ctrl.filter.shippingId']")}
	
		descriptionSort { $("table#list th[property='description']") }
		imageSort { $("table#list th[property='image']") }
		regularPriceSort { $("table#list th[property='regularPrice']") }
		salePriceSort { $("table#list th[property='salePrice']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList VariationListRow, $("table#list tbody tr") }
    }

}

class VariationListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}