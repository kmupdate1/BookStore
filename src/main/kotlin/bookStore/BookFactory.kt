package bookStore

/**
 * 本の工場
 * 監査機関を通った本が，ここで作られる
 * 作られた本は，一度，依頼元に返す
 */
class BookFactory private constructor(bookFactoryBuilder: BookFactoryBuilder) {
	        val title: String?
	private val author: String?
	private val publisher: String?
	        val price: Int?
	        val weight: Double?
	private val numOfPage: Int?

	init {
		this.title     = bookFactoryBuilder.title
		this.author    = bookFactoryBuilder.author
		this.publisher = bookFactoryBuilder.publisher
		this.price     = bookFactoryBuilder.price
		this.weight    = bookFactoryBuilder.weight
		this.numOfPage = bookFactoryBuilder.numOfPage
	}

	class BookFactoryBuilder {
		var title: String?     = null
			private set
		var author: String?    = null
			private set
		var publisher: String? = null
			private set
		var price: Int?        = null
			private set
		var weight: Double?    = null
			private set
		var numOfPage: Int?    = null
			private set

		fun title(title: String)         = apply { this.title = title }
		fun author(author: String)       = apply { this.author = author }
		fun publisher(publisher: String) = apply { this.publisher = publisher }
		fun price(price: Int)            = apply { this.price = price }
		fun weight(weight: Double)       = apply { this.weight = weight }
		fun numOfPage(numOfPage: Int)    = apply { this.numOfPage = numOfPage }

		fun build() = BookFactory(this)
	}
}
