package Lab4.problem2;

/**
 * describes  a mutable PriorityQueue ADT
 * @param <T> this is datatype of Element in queue
 */
public interface PriorityQueueADT<T> {

  /**
   * insert the object into the queue. Use the Comparable method
   * compareTo() to implement the ordering
   * @param e the element to add
   */
  void insert(T e);

  /**
   * removes and returns the object at the front. Throw an appropriate
   * exception if the Priority Queue is empty.
   * @return the element at the front
   */
  T remove();

  /**
   * returns the object at the front without changing the Priority Queue.
   * Throw and appropriate exception if the Priority Queue is empty.
   * @return the element at the front
   */
  T front();

  /**
   * returns true if the queue is empty
   * @return boolean
   */
  boolean isEmpty();
}
