package uk.ac.leedsbeckett

class Employee {
    String firstName
    String lastName
    Date birthDate
    BigDecimal salary

    static constraints = {
        birthDate(required: true)
    }
}