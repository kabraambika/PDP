package Lab4.problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
  private Queue<Integer> queueADT;
  @BeforeEach
  void setUp() {
    queueADT = new QueueADT<Integer>();
  }

  @Test
  void enqueueTest() {
    assertTrue(Boolean.TRUE);
  }

  @Test
  void dequeueTest() {
  }

  @Test
  void frontTest() {
  }

  public class QueueADT<T> implements Queue<T> {
    public QueueADT() {

    }
    /**
     * Adds an element to the queue.
     *
     * @param element The element to add.
     * @return A new Queue with the element added.
     */
    @Override
    public Queue enqueue(T element) {
      return null;
    }

    /**
     * Removes the least recently added element.
     *
     * @return A new Queue with element removed.
     */
    @Override
    public Queue dequeue() {
      return null;
    }

    /**
     * Returns but does not remove the least recently added element.
     *
     * @return The element at the front of the Queue.
     */
    @Override
    public T front() {
      return null;
    }
  }
}