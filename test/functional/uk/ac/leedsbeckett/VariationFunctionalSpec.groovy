package uk.ac.leedsbeckett

import uk.ac.leedsbeckett.pages.variation.*
import geb.spock.GebReportingSpec


class VariationFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to VariationListPage

		then:
		at VariationListPage
	}
	
	def "should be able to create a valid Variation"() {
		when:
		to VariationListPage

		and:
		createButton.click()

		then:
		at VariationCreatePage

		when:
		descriptionField = "Foo"
		imageField = imageField.find('option').value()
		regularPriceField = regularPriceField.find('option').value()
		salePriceField = salePriceField.find('option').value()
		shippingField = shippingField.find('option').value()
			
		and:
		saveButton.click()

		then:
		at VariationShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Variation was successfully created"
	}
	
	def "should be able to sort the Variation List"() {
		given:
		to VariationListPage

		when:
		descriptionSort.click()
		
		then:
		descriptionSort.classes().contains("asc")

		when:
		imageSort.click()
		
		then:
		imageSort.classes().contains("asc")

		when:
		regularPriceSort.click()
		
		then:
		regularPriceSort.classes().contains("asc")

		when:
		salePriceSort.click()
		
		then:
		salePriceSort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Variation List"() {
		given:
		to VariationListPage

		when:
		descriptionFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		imageFilter = imageFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }

		when:
		regularPriceFilter = regularPriceFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }

		when:
		salePriceFilter = salePriceFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Variation"() {
		when:
		to VariationListPage

		and:
		rows.first().editButton.click()

		then:
		at VariationEditPage
		
		when:
		descriptionField = "Foo!"
		imageField = imageField.find('option').value()
		regularPriceField = regularPriceField.find('option').value()
		salePriceField = salePriceField.find('option').value()
		shippingField = shippingField.find('option').value()
		
		and:
		saveButton.click()
		
		then:
		at VariationShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Variation was successfully updated"
	}
	
	def "should be able to delete the first Variation"() {
		when:
		to VariationListPage

		and:
		rows.first().deleteButton.click()

		then:
		at VariationListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Variation was successfully deleted"
      }
	
}