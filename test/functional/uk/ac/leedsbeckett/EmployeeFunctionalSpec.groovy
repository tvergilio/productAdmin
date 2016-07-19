package uk.ac.leedsbeckett

import uk.ac.leedsbeckett.pages.employee.*
import geb.spock.GebReportingSpec


class EmployeeFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to EmployeeListPage

		then:
		at EmployeeListPage
	}
	
	def "should be able to create a valid Employee"() {
		when:
		to EmployeeListPage

		and:
		createButton.click()

		then:
		at EmployeeCreatePage

		when:
		firstNameField = "Foo"
		lastNameField = "Foo"
		birthDateField = "01/01/2001"
		salaryField = 99
			
		and:
		saveButton.click()

		then:
		at EmployeeShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Employee was successfully created"
	}
	
	def "should be able to sort the Employee List"() {
		given:
		to EmployeeListPage

		when:
		firstNameSort.click()
		
		then:
		firstNameSort.classes().contains("asc")

		when:
		lastNameSort.click()
		
		then:
		lastNameSort.classes().contains("asc")

		when:
		birthDateSort.click()
		
		then:
		birthDateSort.classes().contains("asc")

		when:
		salarySort.click()
		
		then:
		salarySort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Employee List"() {
		given:
		to EmployeeListPage

		when:
		firstNameFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		lastNameFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		birthDateFilter = "01/01/2001"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		salaryFilter = 99
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Employee"() {
		when:
		to EmployeeListPage

		and:
		rows.first().editButton.click()

		then:
		at EmployeeEditPage
		
		when:
		firstNameField = "Foo!"
		lastNameField = "Foo!"
		birthDateField = "02/01/2001"
		salaryField = 100
		
		and:
		saveButton.click()
		
		then:
		at EmployeeShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Employee was successfully updated"
	}
	
	def "should be able to delete the first Employee"() {
		when:
		to EmployeeListPage

		and:
		rows.first().deleteButton.click()

		then:
		at EmployeeListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Employee was successfully deleted"
      }
	
}