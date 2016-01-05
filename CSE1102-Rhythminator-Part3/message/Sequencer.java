package message;


public class Sequencer implements IPublisher, ISubscriber
{
  private SubscriberList _subscribers;
  private int _nextNotify = 0;

  public Sequencer(int numSubscribers)
  {
    _subscribers = new SubscriberList();
  }

  public int getStepNumber()
  {
    return _nextNotify;
  }

  @Override
  public void notify(Message message)
  {
    if(_nextNotify == _subscribers.count())
      _nextNotify = 0;
    SequencerMessage msg = new SequencerMessage(this, _nextNotify);
    //System.out.println("Sequencer.notify " + _nextNotify);
    _subscribers.notify(_nextNotify++, msg);
  }

  public void reset()
  {
    _nextNotify = 0;
  }

  public void setStep(int stepNumber, ISubscriber subscriber)
  {
    _subscribers.subscribe(subscriber);
  }

  @Override
  public void subscribe(ISubscriber subscriber)
  {
    _subscribers.subscribe(subscriber);
  }

  @Override
  public void unsubscribe(ISubscriber subscriber)
  {
    _subscribers.unsubscribe(subscriber);
  }

}
