package uk.ac.leedsbeckett

import uk.ac.leedsbeckett.pages.category.*
import geb.spock.GebReportingSpec


class CategoryFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to CategoryListPage

		then:
		at CategoryListPage
	}
	
	def "should be able to create a valid Category"() {
		when:
		to CategoryListPage

		and:
		createButton.click()

		then:
		at CategoryCreatePage

		when:
		nameField = "Foo"
		descriptionField = "Foo"
		imageField = imageField.find('option').value()
		parentField = parentField.find('option').value()
			
		and:
		saveButton.click()

		then:
		at CategoryShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Category was successfully created"
	}
	
	def "should be able to sort the Category List"() {
		given:
		to CategoryListPage

		when:
		nameSort.click()
		
		then:
		nameSort.classes().contains("asc")

		when:
		descriptionSort.click()
		
		then:
		descriptionSort.classes().contains("asc")

		when:
		imageSort.click()
		
		then:
		imageSort.classes().contains("asc")

		when:
		parentSort.click()
		
		then:
		parentSort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Category List"() {
		given:
		to CategoryListPage

		when:
		nameFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		descriptionFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		imageFilter = imageFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }

		when:
		parentFilter = parentFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Category"() {
		when:
		to CategoryListPage

		and:
		rows.first().editButton.click()

		then:
		at CategoryEditPage
		
		when:
		nameField = "Foo!"
		descriptionField = "Foo!"
		imageField = imageField.find('option').value()
		parentField = parentField.find('option').value()
		
		and:
		saveButton.click()
		
		then:
		at CategoryShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Category was successfully updated"
	}
	
	def "should be able to delete the first Category"() {
		when:
		to CategoryListPage

		and:
		rows.first().deleteButton.click()

		then:
		at CategoryListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Category was successfully deleted"
      }
	
}