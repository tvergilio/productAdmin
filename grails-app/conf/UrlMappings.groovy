class UrlMappings {

	static mappings = {

        																																																														'/category'(view: 'category')
		'/api/category'(resources: 'category')
'/variation'(view: 'variation')
		'/api/variation'(resources: 'variation')
'/tag'(view: 'tag')
		'/api/tag'(resources: 'tag')
'/shipping'(view: 'shipping')
		'/api/shipping'(resources: 'shipping')
'/product'(view: 'product')
		'/api/product'(resources: 'product')
'/image'(view: 'image')
		'/api/image'(resources: 'image')
'/feature'(view: 'feature')
		'/api/feature'(resources: 'feature')
'/category'(view: 'category')
		'/api/category'(resources: 'category')
'/tag'(view: 'tag')
		'/api/tag'(resources: 'tag')
'/variation'(view: 'variation')
		'/api/variation'(resources: 'variation')
'/tag'(view: 'tag')
		'/api/tag'(resources: 'tag')
'/shipping'(view: 'shipping')
		'/api/shipping'(resources: 'shipping')
'/product'(view: 'product')
		'/api/product'(resources: 'product')
'/image'(view: 'image')
		'/api/image'(resources: 'image')
'/feature'(view: 'feature')
		'/api/feature'(resources: 'feature')
'/category'(view: 'category')
		'/api/category'(resources: 'category')
'/variation'(view: 'variation')
		'/api/variation'(resources: 'variation')
'/tag'(view: 'tag')
		'/api/tag'(resources: 'tag')
'/shipping'(view: 'shipping')
		'/api/shipping'(resources: 'shipping')
'/product'(view: 'product')
		'/api/product'(resources: 'product')
'/image'(view: 'image')
		'/api/image'(resources: 'image')
'/feature'(view: 'feature')
		'/api/feature'(resources: 'feature')
'/category'(view: 'category')
		'/api/category'(resources: 'category')
'/variation'(view: 'variation')
		'/api/variation'(resources: 'variation')
'/tag'(view: 'tag')
		'/api/tag'(resources: 'tag')
'/shipping'(view: 'shipping')
		'/api/shipping'(resources: 'shipping')
'/image'(view: 'image')
		'/api/image'(resources: 'image')
'/feature'(view: 'feature')
		'/api/feature'(resources: 'feature')
'/category'(view: 'category')
		'/api/category'(resources: 'category')
'/product'(view: 'product')
		'/api/product'(resources: 'product')
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
