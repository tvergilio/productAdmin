package uk.ac.leedsbeckett.pages.tag

import geb.Module
import geb.Page

class TagListPage extends Page {

    static url = "tag"

    static at = { $('h2').text() == 'Tag List' }

    static content = {
		nameFilter {$("input[ng-model='ctrl.filter.name']")}
		descriptionFilter {$("input[ng-model='ctrl.filter.description']")}
	
		nameSort { $("table#list th[property='name']") }
		descriptionSort { $("table#list th[property='description']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList TagListRow, $("table#list tbody tr") }
    }

}

class TagListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}