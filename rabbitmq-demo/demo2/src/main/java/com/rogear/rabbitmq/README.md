RabbitMQ

死信队列DLX（dead letter exchange）

一个消息在队列中变为死信（dead letter）后，它可以被重新发布到一个Exchange，进行其它的操作

变为死信有几种方式：
1、消息被拒绝，并且requeue；
2、消息过期；
3、消息超过最大长度