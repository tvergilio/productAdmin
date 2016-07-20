package uk.ac.leedsbeckett
import uk.ac.leedsbeckett.Product

class ProductController extends PagedRestfulController {
    ProductController() {
        super(Product)
    }
}