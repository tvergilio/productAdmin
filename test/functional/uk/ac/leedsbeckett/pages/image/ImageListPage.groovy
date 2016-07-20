package uk.ac.leedsbeckett.pages.image

import geb.Module
import geb.Page

class ImageListPage extends Page {

    static url = "image"

    static at = { $('h2').text() == 'Image List' }

    static content = {

	

    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList ImageListRow, $("table#list tbody tr") }
    }

}

class ImageListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}