package uk.ac.leedsbeckett

import uk.ac.leedsbeckett.pages.product.*
import geb.spock.GebReportingSpec


class ProductFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to ProductListPage

		then:
		at ProductListPage
	}
	
	def "should be able to create a valid Product"() {
		when:
		to ProductListPage

		and:
		createButton.click()

		then:
		at ProductCreatePage

		when:
		nameField = "Foo"
		descriptionField = "Foo"
		longDescriptionField = "Foo"
		regularPriceField = regularPriceField.find('option').value()
		salesPriceField = salesPriceField.find('option').value()
		shippingField = shippingField.find('option').value()
			
		and:
		saveButton.click()

		then:
		at ProductShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Product was successfully created"
	}
	
	def "should be able to sort the Product List"() {
		given:
		to ProductListPage

		when:
		nameSort.click()
		
		then:
		nameSort.classes().contains("asc")

		when:
		descriptionSort.click()
		
		then:
		descriptionSort.classes().contains("asc")

		when:
		longDescriptionSort.click()
		
		then:
		longDescriptionSort.classes().contains("asc")

		when:
		regularPriceSort.click()
		
		then:
		regularPriceSort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Product List"() {
		given:
		to ProductListPage

		when:
		nameFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		descriptionFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		longDescriptionFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		regularPriceFilter = regularPriceFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Product"() {
		when:
		to ProductListPage

		and:
		rows.first().editButton.click()

		then:
		at ProductEditPage
		
		when:
		nameField = "Foo!"
		descriptionField = "Foo!"
		longDescriptionField = "Foo!"
		regularPriceField = regularPriceField.find('option').value()
		salesPriceField = salesPriceField.find('option').value()
		shippingField = shippingField.find('option').value()
		
		and:
		saveButton.click()
		
		then:
		at ProductShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Product was successfully updated"
	}
	
	def "should be able to delete the first Product"() {
		when:
		to ProductListPage

		and:
		rows.first().deleteButton.click()

		then:
		at ProductListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Product was successfully deleted"
      }
	
}