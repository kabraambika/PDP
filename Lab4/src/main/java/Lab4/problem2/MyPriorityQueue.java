package Lab4.problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MyPriorityQueue is a custom priority queue class, implements PriorityQueueADT interface
 * @param <E> the data type to store in the queue which should extend Comparable
 */
public class MyPriorityQueue<E extends Comparable<E>> implements PriorityQueueADT<E> {
  private List<E> queue;

  /**
   * Constructor
   */
  public MyPriorityQueue() {
    this.queue = new ArrayList<>();
  }

  /**
   * insert the object into the queue. Use the Comparable method compareTo() to implement the
   * ordering
   *
   * @param e the element to add
   */
  @Override
  public void insert(E e) {
    this.queue.add(e);
    compare();
  }

  /**
   * Comparable method to implement the ordering.
   */
  public void compare() {
    for (int outerIndex = this.queue.size() - 1; outerIndex > 0; outerIndex--) {
      for (int innerIndex = 0; innerIndex < outerIndex; innerIndex++) {
        if (queue.get(innerIndex).compareTo(queue.get(innerIndex + 1)) < 0) {
          Collections.swap(this.queue, innerIndex, innerIndex + 1);
        }
      }
    }
  }

  /**
   * removes and returns the object at the front. Throw an appropriate exception if the Priority
   * Queue is empty.
   *
   * @return the element at the front
   */
  @Override
  public E remove() {
    if(isEmpty()) {
      throw new QueueEmptyException("Queue is already empty");
    }
    E frontElement = this.queue.get(0);
    this.queue = this.queue.subList(1, this.queue.size()-1);

    return frontElement;
  }

  /**
   * returns the object at the front without changing the Priority Queue. Throw and appropriate
   * exception if the Priority Queue is empty.
   *
   * @return the element at the front
   */
  @Override
  public E front() {
    if(isEmpty()) {
      throw new QueueEmptyException("Queue is already empty");
    }

    return (E) this.queue.get(0);
  }

  /**
   * returns true if the queue is empty
   *
   * @return boolean
   */
  @Override
  public boolean isEmpty() {
    return this.queue.size() == 0;
  }

  @Override
  public String toString() {
    return "MyPriorityQueue{" +
        "queue=" + this.queue +
        '}';
  }
}
