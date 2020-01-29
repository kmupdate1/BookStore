package bookStore

interface IDeliver {
	fun deliver(title: String)
}

interface IPurchase {
	fun purchase(title: String)
}

interface IRead {
	fun read(title: String)
}
