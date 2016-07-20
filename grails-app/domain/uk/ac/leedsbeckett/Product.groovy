package uk.ac.leedsbeckett

class Product {
    String name
    String description
    String longDescription
    Double regularPrice
    Double salesPrice
    Shipping shipping

    static hasMany = [tags: Tag, categories: Category, variations: Variation, images: Image]

    static constraints = {
        tags nullable: true
        categories nullable: true
        variations nullable: true
        images nullable: true
        longDescription nullable: true
        salesPrice nullable: true
    }
}
