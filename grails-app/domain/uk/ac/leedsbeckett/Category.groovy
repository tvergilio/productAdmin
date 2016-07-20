package uk.ac.leedsbeckett

class Category {

    String name
    String description
    Image image
    Category parent

    static constraints = {
        parent nullable: true
    }

}
