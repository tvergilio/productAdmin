package uk.ac.leedsbeckett

import uk.ac.leedsbeckett.pages.tag.*
import geb.spock.GebReportingSpec


class TagFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to TagListPage

		then:
		at TagListPage
	}
	
	def "should be able to create a valid Tag"() {
		when:
		to TagListPage

		and:
		createButton.click()

		then:
		at TagCreatePage

		when:
		nameField = "Foo"
		descriptionField = "Foo"
			
		and:
		saveButton.click()

		then:
		at TagShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Tag was successfully created"
	}
	
	def "should be able to sort the Tag List"() {
		given:
		to TagListPage

		when:
		nameSort.click()
		
		then:
		nameSort.classes().contains("asc")

		when:
		descriptionSort.click()
		
		then:
		descriptionSort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Tag List"() {
		given:
		to TagListPage

		when:
		nameFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		descriptionFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Tag"() {
		when:
		to TagListPage

		and:
		rows.first().editButton.click()

		then:
		at TagEditPage
		
		when:
		nameField = "Foo!"
		descriptionField = "Foo!"
		
		and:
		saveButton.click()
		
		then:
		at TagShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Tag was successfully updated"
	}
	
	def "should be able to delete the first Tag"() {
		when:
		to TagListPage

		and:
		rows.first().deleteButton.click()

		then:
		at TagListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Tag was successfully deleted"
      }
	
}