package uk.ac.leedsbeckett

import grails.converters.JSON

class CustomMarshallerRegistrar {
    
    void registerMarshallers() {

		JSON.registerObjectMarshaller(uk.ac.leedsbeckett.Category) {
			def map = [:]
			map['id'] = it?.id
			map['name'] = it?.name
			map['description'] = it?.description
			map['image'] = it?.image
			map['parent'] = it?.parent
	    	map['toText'] = it?.toString()
			return map 
		}

		

		

		JSON.registerObjectMarshaller(uk.ac.leedsbeckett.Variation) {
			def map = [:]
			map['id'] = it?.id
			map['description'] = it?.description
			map['image'] = it?.image
			map['regularPrice'] = it?.regularPrice
			map['salePrice'] = it?.salePrice
			map['shipping'] = it?.shipping
	    	map['toText'] = it?.toString()
			return map 
		}

		JSON.registerObjectMarshaller(uk.ac.leedsbeckett.Tag) {
			def map = [:]
			map['id'] = it?.id
			map['name'] = it?.name
			map['description'] = it?.description
	    	map['toText'] = it?.toString()
			return map 
		}

		JSON.registerObjectMarshaller(uk.ac.leedsbeckett.Shipping) {
			def map = [:]
			map['id'] = it?.id
			map['name'] = it?.name
			map['enabled'] = it?.enabled
			map['cost'] = it?.cost
	    	map['toText'] = it?.toString()
			return map 
		}

		JSON.registerObjectMarshaller(uk.ac.leedsbeckett.Product) {
			def map = [:]
			map['id'] = it?.id
			map['name'] = it?.name
			map['description'] = it?.description
			map['longDescription'] = it?.longDescription
			map['regularPrice'] = it?.regularPrice
			map['salesPrice'] = it?.salesPrice
			map['shipping'] = it?.shipping
	    	map['toText'] = it?.toString()
			return map 
		}

		JSON.registerObjectMarshaller(uk.ac.leedsbeckett.Image) {
			def map = [:]
			map['id'] = it?.id
			
	    	map['toText'] = it?.toString()
			return map 
		}

		JSON.registerObjectMarshaller(uk.ac.leedsbeckett.Feature) {
			def map = [:]
			map['id'] = it?.id
			map['name'] = it?.name
	    	map['toText'] = it?.toString()
			return map 
		}

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		

		JSON.registerObjectMarshaller(uk.ac.leedsbeckett.Employee) {
			def map = [:]
			map['id'] = it?.id
			map['firstName'] = it?.firstName
			map['lastName'] = it?.lastName
			map['birthDate'] = it?.birthDate
			map['salary'] = it?.salary
	    	map['toText'] = it?.toString()
			return map 
		} 
	}

}