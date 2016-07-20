package uk.ac.leedsbeckett

import uk.ac.leedsbeckett.pages.shipping.*
import geb.spock.GebReportingSpec


class ShippingFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to ShippingListPage

		then:
		at ShippingListPage
	}
	
	def "should be able to create a valid Shipping"() {
		when:
		to ShippingListPage

		and:
		createButton.click()

		then:
		at ShippingCreatePage

		when:
		nameField = "Foo"
		enabledField = enabledField.find('option').value()
		costField = costField.find('option').value()
			
		and:
		saveButton.click()

		then:
		at ShippingShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Shipping was successfully created"
	}
	
	def "should be able to sort the Shipping List"() {
		given:
		to ShippingListPage

		when:
		nameSort.click()
		
		then:
		nameSort.classes().contains("asc")

		when:
		enabledSort.click()
		
		then:
		enabledSort.classes().contains("asc")

		when:
		costSort.click()
		
		then:
		costSort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Shipping List"() {
		given:
		to ShippingListPage

		when:
		nameFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		enabledFilter = enabledFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }

		when:
		costFilter = costFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Shipping"() {
		when:
		to ShippingListPage

		and:
		rows.first().editButton.click()

		then:
		at ShippingEditPage
		
		when:
		nameField = "Foo!"
		enabledField = enabledField.find('option').value()
		costField = costField.find('option').value()
		
		and:
		saveButton.click()
		
		then:
		at ShippingShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Shipping was successfully updated"
	}
	
	def "should be able to delete the first Shipping"() {
		when:
		to ShippingListPage

		and:
		rows.first().deleteButton.click()

		then:
		at ShippingListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Shipping was successfully deleted"
      }
	
}