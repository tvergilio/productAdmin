package uk.ac.leedsbeckett.pages.employee

import geb.Module
import geb.Page

class EmployeeListPage extends Page {

    static url = "employee"

    static at = { $('h2').text() == 'Employee List' }

    static content = {
		firstNameFilter {$("input[ng-model='ctrl.filter.firstName']")}
		lastNameFilter {$("input[ng-model='ctrl.filter.lastName']")}
		birthDateFilter {$("input[ng-model='ctrl.filter.birthDate']")}
		salaryFilter {$("input[ng-model='ctrl.filter.salary']")}
	
		firstNameSort { $("table#list th[property='firstName']") }
		lastNameSort { $("table#list th[property='lastName']") }
		birthDateSort { $("table#list th[property='birthDate']") }
		salarySort { $("table#list th[property='salary']") }
    
	    createButton { $("button[crud-button='create']") }
        successMessage { $(".alert-success") }
		
        rows { moduleList EmployeeListRow, $("table#list tbody tr") }
    }

}

class EmployeeListRow extends Module {

	static content = {
		cell { $("td") }
        editButton {$("button[crud-button='edit']")}
        deleteButton {$("button[crud-button='delete']")}
    }

}