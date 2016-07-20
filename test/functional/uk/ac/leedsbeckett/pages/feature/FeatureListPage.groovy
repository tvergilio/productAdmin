package uk.ac.leedsbeckett.pages.feature

import geb.Module
import geb.Page

class FeatureListPage extends Page {

    static url = "feature"

    static at = { $('h2').text() == 'Feature List' }

    static content = {
		nameFilter {$("input[ng-model='ctrl.filter.name']")}
	
		nameSort { $("table#list th[property='name']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList FeatureListRow, $("table#list tbody tr") }
    }

}

class FeatureListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}