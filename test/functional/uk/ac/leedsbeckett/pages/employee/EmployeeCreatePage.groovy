package uk.ac.leedsbeckett.pages.employee

import geb.Module
import geb.Page

class EmployeeCreatePage extends Page {

    static url = "employee#/create"

    static at = { $('h2').text() == 'Create Employee' }

    static content = { 
		firstNameField {$("input[ng-model='ctrl.employee.firstName']")}
		lastNameField {$("input[ng-model='ctrl.employee.lastName']")}
		birthDateField {$("input[ng-model='ctrl.employee.birthDate']")}
		salaryField {$("input[ng-model='ctrl.employee.salary']")}
        saveButton { $('button[crud-button="save"]') }
    }

}