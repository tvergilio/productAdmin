package uk.ac.leedsbeckett.pages.product

import geb.Module
import geb.Page

class ProductListPage extends Page {

    static url = "product"

    static at = { $('h2').text() == 'Product List' }

    static content = {
		nameFilter {$("input[ng-model='ctrl.filter.name']")}
		descriptionFilter {$("input[ng-model='ctrl.filter.description']")}
		longDescriptionFilter {$("input[ng-model='ctrl.filter.longDescription']")}
		regularPriceFilter {$("input[ng-model='ctrl.filter.regularPrice']")}
		salesPriceFilter {$("input[ng-model='ctrl.filter.salesPrice']")}
		shippingFilter {$("select[ng-model='ctrl.filter.shippingId']")}
	
		nameSort { $("table#list th[property='name']") }
		descriptionSort { $("table#list th[property='description']") }
		longDescriptionSort { $("table#list th[property='longDescription']") }
		regularPriceSort { $("table#list th[property='regularPrice']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList ProductListRow, $("table#list tbody tr") }
    }

}

class ProductListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}