class UrlMappings {

	static mappings = {

        		'/employee'(view: 'employee')
		'/api/employee'(resources: 'employee')
"/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
