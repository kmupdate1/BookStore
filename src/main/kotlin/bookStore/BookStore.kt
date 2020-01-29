package bookStore

/**
 * 本屋さんなので，オンラインショップを展開したり（その後デリバリー）
 * その場で購入したり
 * 立ち読みするお客さんがいる
 */
class BookStore(val book: Book): IDeliver, IPurchase, IRead {
    init {
        ReceiveOrder(this)
    }

    override fun deliver(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if (judgeIsExistBook(book, title)) {
            object : Display {
                override fun display() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    val deliveryCost = book.weight!!.times(1.2)
                    println("商品は${book.title}になります．よろしいですか？\n" +
                            "お値段は${book.price}です．\n" +
                            "今回はオンラインでのご注文ですので，送料が${deliveryCost}円となります．\n" +
                            "お会計は${book.price?.plus(deliveryCost)}円です．\n" +
                            "=====================================================\n")
                    println()
                }
            }
        } else {
            commonDisplay()
        }
    }

    override fun purchase(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if (judgeIsExistBook(book, title)) {
            object : Display {
                override fun display() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    println("商品は${book.title}になります．よろしいですか？\n" +
                            "お値段は${book.price}です．\n" +
                            "お買い上げ，ありがとうございました．\n" +
                            "=====================================================\n")
                    println()
                }
            }
        } else {
            commonDisplay()
        }
    }

    override fun read(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if (judgeIsExistBook(book, title)) {
            object : Display {
                override fun display() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    println("あなたは${book.title}を読んでいますね．これ良い本ですね．\n" +
                            "お値段は${book.price}です．\n" +
                            "ご注文なさいますか？\n" +
                            "=====================================================\n")
                    println()
                }
            }
        } else {
            commonDisplay()
        }
    }

    private fun commonDisplay() = println("商品がありません．")
}

fun judgeIsExistBook(bookTitle: Book, title: String?): Boolean = title.equals(bookTitle.title)

// book storeの在庫（または本棚）
// 本屋は最悪，本のタイトル・値段・出荷時のための重量さえ分かってれば，仕事が完結する
data class Book(val book: BookFactory) {
    val title: String? = book.title
    // val author: String? = book.author
    // val publisher: String? = book.publisher
    val price: Int? = book.price
    val weight: Double? = book.weight
    // val numOfPage: Int? = book.numOfPage
}

interface Display {
    fun display()
}
