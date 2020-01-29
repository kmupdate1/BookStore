package bookStore

import java.lang.Thread.sleep

class MakeConsumer {
    private lateinit var consumers: MutableList<Consumer>
    private lateinit var receiveOrder: ReceiveOrder

    constructor(consumers: MutableList<Consumer>) { this.consumers = consumers }
    constructor(receiveOrder: ReceiveOrder) { this.receiveOrder = receiveOrder }

    private val consumer1 = object: Thread() {
        override fun run() {
            println("私の名前は${consumers[0].name}です．\n" +
                    "今から${consumers[0].title}を'書店'で買おうと思います．\n" +
                    "-----------------------------------------------------")
            receiveOrder.orderPurchase(consumers[0].title)
        }
    }
    private val consumer2 = object : Thread() {
        override fun run() {
            println("私の名前は${consumers[1].name}です．\n" +
                    "今から${consumers[1].title}を'オンライン'で配送の注文をしようと思います．\n" +
                    "-----------------------------------------------------")
            receiveOrder.orderDelivery(consumers[1].title)
        }
    }
    private val consumer3 = object : Thread() {
        override fun run() {
            println("私の名前は${consumers[2].name}です．\n" +
                    "今から${consumers[2].title}を'オンライン'で配送の注文をしようと思います．\n" +
                    "-----------------------------------------------------")
            receiveOrder.orderDelivery(consumers[2].title)
        }
    }
    private val consumer4 = object : Thread() {
        override fun run() {
            println("私の名前は${consumers[3].name}です．\n" +
                    "今から${consumers[3].title}を'立ち読み'しようと思います．\n" +
                    "-----------------------------------------------------")
            receiveOrder.orderRead(consumers[3].title)
        }
    }
    private val consumer5 = object : Thread() {
        override fun run() {
            println("私の名前は${consumers[4].name}です．\n" +
                    "今から${consumers[4].title}を'書店'で買おうと思います．\n" +
                    "-----------------------------------------------------")
            receiveOrder.orderPurchase(consumers[4].title)
        }
    }

    fun makeConsumerThread() {
        sleep(5000)
        consumer1.start()
        sleep(10000)
        consumer2.start()
        sleep(5000)
        consumer3.start()
        sleep(10000)
        consumer4.start()
        sleep(5000)
        consumer5.start()
    }

    interface OrderedDeliveryListener {
        fun orderDelivery(title: String)
        fun orderPurchase(title: String)
        fun orderRead(title: String)
    }
}

data class Consumer(val name: String, val title: String)
