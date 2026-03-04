from kafka import KafkaConsumer
import json

consumer = KafkaConsumer(
    'notifications',
    bootstrap_servers=['localhost:9092'],
    group_id='consumer-group',
    value_deserializer=lambda x: json.loads(x.decode('utf-8'))
)

for message in consumer:
    notification = message.value # словарик

    print(f"Получено сообщение: {notification}")