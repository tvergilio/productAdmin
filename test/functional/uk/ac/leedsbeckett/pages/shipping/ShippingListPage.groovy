package uk.ac.leedsbeckett.pages.shipping

import geb.Module
import geb.Page

class ShippingListPage extends Page {

    static url = "shipping"

    static at = { $('h2').text() == 'Shipping List' }

    static content = {
		nameFilter {$("input[ng-model='ctrl.filter.name']")}
		enabledFilter {$("input[ng-model='ctrl.filter.enabled']")}
		costFilter {$("input[ng-model='ctrl.filter.cost']")}
	
		nameSort { $("table#list th[property='name']") }
		enabledSort { $("table#list th[property='enabled']") }
		costSort { $("table#list th[property='cost']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList ShippingListRow, $("table#list tbody tr") }
    }

}

class ShippingListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}