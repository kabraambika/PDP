package Lab4.problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
  public class ImmutableStack<T> implements Stack<T> {
    private ArrayList<T> stackItems;

    public ImmutableStack() {
      this.stackItems = new ArrayList<>();
    }

    public ImmutableStack(ArrayList<T> stackItems) {
      this.stackItems = stackItems;
    }
    /**
     * Pushes an element on to the Stack
     *
     * @param element The element to add to the Stack.
     * @return A new Stack with the new element added.
     */
    @Override
    public Stack push(T element) {
      ArrayList<T> newStackItems = new ArrayList<>();
      newStackItems.addAll(this.stackItems);
      newStackItems.add(element);

      return new ImmutableStack(newStackItems);
    }

    /**
     * Removes the most recently added element.
     *
     * @return A new Stack without the most recently added element.
     */
    @Override
    public Stack remove() {
      this.stackItems.remove(this.stackItems.size() - 1);
      return new ImmutableStack(this.stackItems);
    }

    /**
     * Returns, but does not remove, the most recently added element.
     *
     * @return The most recently added element.
     */
    @Override
    public T top() {
      T topElement = this.stackItems.get(this.stackItems.size() - 1);
      return topElement;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      ImmutableStack<?> that = (ImmutableStack<?>) o;
      return Objects.equals(stackItems, that.stackItems);
    }

    @Override
    public int hashCode() {
      return Objects.hash(stackItems);
    }

    @Override
    public String toString() {
      return "ImmutableStack{" +
          "stackItems=" + stackItems +
          '}';
    }
  }
  private Stack<Integer> stackTest1;
  @BeforeEach
  void setUp() {
    stackTest1 = new ImmutableStack<>();
  }

  @Test
  void pushTest() {
    stackTest1 = stackTest1.push(7);
    stackTest1 = stackTest1.push(4);
    stackTest1 = stackTest1.push(5);
  }

  @Test
  void removeTest() {
    stackTest1 = stackTest1.push(7);
    stackTest1 = stackTest1.push(4);
    stackTest1 = stackTest1.push(5);
    Stack<Integer> newStackTest = new ImmutableStack<>();
    newStackTest = newStackTest.push(7);
    newStackTest = newStackTest.push(4);
    assertEquals(newStackTest, stackTest1.remove());
  }

  @Test
  void topTest() {
    stackTest1 = stackTest1.push(7);
    stackTest1 = stackTest1.push(4);
    assertEquals(4, stackTest1.top());
  }
}