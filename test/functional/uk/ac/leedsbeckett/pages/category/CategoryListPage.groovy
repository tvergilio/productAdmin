package uk.ac.leedsbeckett.pages.category

import geb.Module
import geb.Page

class CategoryListPage extends Page {

    static url = "category"

    static at = { $('h2').text() == 'Category List' }

    static content = {
		nameFilter {$("input[ng-model='ctrl.filter.name']")}
		descriptionFilter {$("input[ng-model='ctrl.filter.description']")}
		imageFilter {$("select[ng-model='ctrl.filter.imageId']")}
		parentFilter {$("select[ng-model='ctrl.filter.parentId']")}
	
		nameSort { $("table#list th[property='name']") }
		descriptionSort { $("table#list th[property='description']") }
		imageSort { $("table#list th[property='image']") }
		parentSort { $("table#list th[property='parent']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList CategoryListRow, $("table#list tbody tr") }
    }

}

class CategoryListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}