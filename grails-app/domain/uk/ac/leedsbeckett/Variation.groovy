package uk.ac.leedsbeckett

class Variation {
    String description
    Image image
    Double regularPrice
    Double salePrice
    Shipping shipping

    static belongsTo = [product: Product]
    static hasMany = [features: Feature]
}
