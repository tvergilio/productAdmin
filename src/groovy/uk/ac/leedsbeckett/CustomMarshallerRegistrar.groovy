package uk.ac.leedsbeckett

import grails.converters.JSON

class CustomMarshallerRegistrar {
    
    void registerMarshallers() {

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