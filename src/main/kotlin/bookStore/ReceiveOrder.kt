package bookStore

/**
 * 消費者がある日気まぐれで（別スレッドにしてある）書店に遊びにきた
 * 直接書店にくるか，書店のホームページを覗いてる
 */
class ReceiveOrder(private val bookStore: BookStore): MakeConsumer.OrderedDeliveryListener{
    init {
        MakeConsumer(this)
    }

    override fun orderDelivery(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        bookStore.deliver(title)
    }

    override fun orderPurchase(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        bookStore.purchase(title)
    }

    override fun orderRead(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        bookStore.read(title)
    }
}
