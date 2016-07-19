package uk.ac.leedsbeckett.pages.employee

import geb.Module
import geb.Page

class EmployeeEditPage extends Page {

    static url = "employee#/create"

    static at = { $('h2').text() == 'Edit Employee' }

    static content = {
		firstNameField {$("input[ng-model='ctrl.employee.firstName']")}
		lastNameField {$("input[ng-model='ctrl.employee.lastName']")}
		birthDateField {$("input[ng-model='ctrl.employee.birthDate']")}
		salaryField {$("input[ng-model='ctrl.employee.salary']")}
        saveButton { $('button[crud-button="save"]') }
    }

}