package uk.ac.leedsbeckett
import uk.ac.leedsbeckett.Employee

class EmployeeController extends PagedRestfulController {
    EmployeeController() {
        super(Employee)
    }
}