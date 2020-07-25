# RxBus

## Definition
Implement EventBus by using Reactive Extension Java (RxJava). We can implement RxBus by using RxJava's PublishSubject.

## PublishSubject
**PublishSubject** emits all the subsequent items of the source Observable at the time of subscription. For example: if a student entered late into the classroom, he just wanted to listen from that point of time when he entered the classroom. So, Publish will be the best for this use-case.

<img src="https://imgur.com/9FPAflh.png" width="600px" height="350px" />

```
PublishSubject<Object> subject = PublishSubject.create();

// observer1 will receive “one”, “two”, “three”, and onCompleted events
subject.subscribe(observer1);
subject.onNext("one");
subject.onNext("two");

// observer2 will only receive "three" and onCompleted
subject.subscribe(observer2);
subject.onNext("three");
subject.onCompleted();
```

## Implementation
```
implementation 'io.reactivex.rxjava2:rxkotlin:2.3.0'
implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'
```

## Steps To Implement RxBus
### Create a Singleton Class Called RxBus
```
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

object RxBus {

   private val publisher = PublishSubject.create<Any>()

   fun publish(event: Any) {
      publisher.onNext(event)
   }

   // Listen should return an Observable and not the publisher
   // Using ofType we filter only events that match that class type
   fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)
}

```

### Create An Event
```
class RxBusEvent {
   data class MessageEvent(val message: String)
}

```

### Create The Publisher
`RxBus.publish(RxBusEvent.MessageEvent(“Hello World!”))`

### Create The Subscriber
```
RxBus.listen(RxBusEvent.MessageEvent::class.java)
           .subscribe { textViewCounter.text = it.message }
```

### Add @SuppressLint annotation
Add **@SuppressLint** annotation on Kotlin to ignore all the errors for the annotated element.
```
@SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
```
