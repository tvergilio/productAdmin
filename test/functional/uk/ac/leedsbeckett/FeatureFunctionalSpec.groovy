package uk.ac.leedsbeckett

import uk.ac.leedsbeckett.pages.feature.*
import geb.spock.GebReportingSpec


class FeatureFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to FeatureListPage

		then:
		at FeatureListPage
	}
	
	def "should be able to create a valid Feature"() {
		when:
		to FeatureListPage

		and:
		createButton.click()

		then:
		at FeatureCreatePage

		when:
		nameField = "Foo"
			
		and:
		saveButton.click()

		then:
		at FeatureShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Feature was successfully created"
	}
	
	def "should be able to sort the Feature List"() {
		given:
		to FeatureListPage

		when:
		nameSort.click()
		
		then:
		nameSort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Feature List"() {
		given:
		to FeatureListPage

		when:
		nameFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Feature"() {
		when:
		to FeatureListPage

		and:
		rows.first().editButton.click()

		then:
		at FeatureEditPage
		
		when:
		nameField = "Foo!"
		
		and:
		saveButton.click()
		
		then:
		at FeatureShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Feature was successfully updated"
	}
	
	def "should be able to delete the first Feature"() {
		when:
		to FeatureListPage

		and:
		rows.first().deleteButton.click()

		then:
		at FeatureListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Feature was successfully deleted"
      }
	
}