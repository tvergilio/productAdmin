package uk.ac.leedsbeckett

import uk.ac.leedsbeckett.pages.image.*
import geb.spock.GebReportingSpec


class ImageFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to ImageListPage

		then:
		at ImageListPage
	}
	
	def "should be able to create a valid Image"() {
		when:
		to ImageListPage

		and:
		createButton.click()

		then:
		at ImageCreatePage

		when:

			
		and:
		saveButton.click()

		then:
		at ImageShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Image was successfully created"
	}
	
	def "should be able to sort the Image List"() {
		given:
		to ImageListPage

	
	}
	
	def "should be able to filter the Image List"() {
		given:
		to ImageListPage

	
	}
	
	def "should be able to edit the first Image"() {
		when:
		to ImageListPage

		and:
		rows.first().editButton.click()

		then:
		at ImageEditPage
		
		when:

		
		and:
		saveButton.click()
		
		then:
		at ImageShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Image was successfully updated"
	}
	
	def "should be able to delete the first Image"() {
		when:
		to ImageListPage

		and:
		rows.first().deleteButton.click()

		then:
		at ImageListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Image was successfully deleted"
      }
	
}