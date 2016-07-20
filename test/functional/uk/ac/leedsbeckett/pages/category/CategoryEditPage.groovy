package uk.ac.leedsbeckett.pages.category

import geb.Module
import geb.Page

class CategoryEditPage extends Page {

    static url = "category#/create"

    static at = { $('h2').text() == 'Edit Category' }

    static content = {
		nameField {$("input[ng-model='ctrl.category.name']")}
		descriptionField {$("input[ng-model='ctrl.category.description']")}
		imageField {$("select[ng-model='ctrl.category.image']")}
		parentField {$("select[ng-model='ctrl.category.parent']")}
        saveButton { $('button[crud-button="save"]') }
    }

}