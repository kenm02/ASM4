//task 1
fun showBrandProducts(brand: String, showBrandProducts: (Product) -> Unit,products: List<Product>) {
    products.filter { it.brand == brand }.forEach(showBrandProducts)
}
// Task2
fun printProducts(products: Product) {
    println("Found ${products.product} from ${products.brand}")
}
//Task3
fun String.isValidProductCode(): Boolean{
    val regex =  Regex("^P[A-Za-z]+\\d{4}[A-Za-z0-9]+$")
    return this.matches(regex)
}
//Task4
fun String.isValidPriceFormat(): Boolean {
    val regex = Regex("^\\d{1,3}(,\\d{3})* VND$")
    return this.matches(regex)
}

fun String.correctPriceFormat(): String {
    return if (this.isValidPriceFormat()) {
        this
    } else {
        val cleanedPrice = this.filter { it.isDigit() }
        val formattedPrice = cleanedPrice.reversed().chunked(3).joinToString(",").reversed()
        "$formattedPrice VND"
    }
}
//Task 5
fun Int.toHexString(): String {
    return this.toString(16)
}
//Task 6
fun String.toBinaryString(): String {
    return this.toInt(16).toString(2)
}


fun main() {
    val products = listOf(
        Product("IphoneX","Apple","PApple2021Q123"),
        Product("Iphone11","Apple","PApple2021Q123"),
        Product("Iphone12","Apple","PApple2021Q123"),
        Product("Samsung J4","Samsung","PSamsung2024J4256"),
        Product("JBL Tour Pro","JBL","PJBL2024TP2012")
    )
    //test task2
    showBrandProducts("Samsung",::printProducts,products)
    val price = "100000 VND"
    //test task 3
    val  productCode = "PApple2021Q123"
    println(productCode.isValidProductCode())
    // test task 4
    if (price.isValidPriceFormat()){
        println(price)
    }else{
        println(price.correctPriceFormat())
    }
    //test task 5
    println(200.toHexString())
    //test task 6
    println("b5".toBinaryString())

}
