package utils;

import java.util.NoSuchElementException;

/**
 * ArrayList.
 *
 * @param <E> E
 */
public class ArrayList<E> implements List<E> {

  public static final int DEFAULT_CAPACITY = 10;

  private E[] array;   //stores internal array of integers.
  private int Size;     //stores the number of elements in list.

  /**
   * Default constructor.
   */
  public ArrayList() {
    // calls the second constructor
    this(DEFAULT_CAPACITY);
    this.Size = 0;
  }

  /**
   * The second constructor generates an internal array with the specified initial capacity.
   *
   * @param capacity capacity
   */
  @SuppressWarnings("unchecked")
  public ArrayList(int capacity) {

    // If the capacity is less than zero, this constructor should throw an IllegalArgumentException.
    if (capacity < 0) {
      throw new IllegalArgumentException();
    }

    array = (E[]) new Object[capacity];
  }

  /**
   * generates an internal array with the elements of another list.
   *
   * @param otherList otherList
   */
  public ArrayList(List<E> otherList) {
    // The default constructor initializes the data
    this();

    // appends the list specified to the end of the list and updates the number of elements.
    this.addAll(otherList);
  }

  /**
   * appends the item specified to the end of the list and updates the number of
   * elements one at a time.
   * This method returns true, if the data was added successfully.
   *
   * @param item item
   * @return true
   */
  @Override
  public boolean add(E item) {
    // If the capacity is insufficient, expand it
    if (Size == array.length) {
      ensureCapacity(2 * array.length);
    }

    array[Size] = item;
    Size++;

    return true;
  }

  /**
   * inserts the item specified at the given index in the list.
   * Shifts subsequent elements to the right and updates the number
   * of elements in list one at a time.
   *
   * @param index index
   * @param item  item
   */
  @Override
  public void add(int index, E item) {
    // Check whether the index is valid
    if (index < 0 || index > Size) {
      throw new IndexOutOfBoundsException();
    }

    if (Size == array.length) {
      ensureCapacity(2 * array.length);
    }

    shiftRight(index);

    array[index] = item;

    Size++;
  }

  /**
   * appends the list specified to the end of the list and updates the number of elements.
   * This method returns true, if the data was added successfully.
   *
   * @param otherList otherList
   * @return result
   */
  @Override
  public boolean addAll(List<E> otherList) {
    for (int i = 0; i < otherList.size(); i++) {

      add(otherList.get(i));

    }

    return true;
  }

  /**
   * checks if the given index is valid. Throws an IndexOutOfBoundsException,
   * if invalid. Validation means that you cannot access indexes where elements
   * have not been placed.
   * This is a private helper method.
   * Note: This method should be used in any method that requires a precondition
   * for access to valid index.
   *
   * @param index index
   */
  private void checkIndex(int index) {
    if (index < 0 || index >= Size) {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * clears list of all elements for garbage collection, returns Size back to zero.
   */
  @Override
  @SuppressWarnings("unchecked")
  public void clear() {
    this.array = (E[]) new Object[DEFAULT_CAPACITY];
    this.Size = 0;
  }

  /**
   * searches for a specific value within the internal array and returns true,
   * if the value is in the list.
   *
   * @param item item
   */
  @Override
  public boolean contains(E item) {
    for (int i = 0; i < size(); i++) {
      if (item.toString().equals(array[i].toString())) {
        return true;
      }
    }

    return false;
  }

  /**
   * doubles the capacity of the underlying array, or if the targetCapacity is greater
   * that double the capacity increases the array to the targetCapacity to
   * ensure that it can hold the number of elements specified by the targetCapacity value.
   * This will most likely have a cast to a generic type.
   *
   * @param targetCapacity targetCapacity
   */
  @SuppressWarnings("unchecked")
  public void ensureCapacity(int targetCapacity) {
    int length = Math.max(targetCapacity, (2 * Size));

    Object[] newData = new Object[length];
    for (int i = 0; i < Size; i++) {
      newData[i] = array[i];
    }
    array = (E[]) newData;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    // If the argument is the object itself, return true directly
    if (o == this) {
      return true;
    }

    // If null, simply return false
    if (o == null) {
      return false;
    }

    List<E> list = (List<E>) o;

    if (list.size() != this.size()) {
      return false;
    }

    for (int i = 0; i < Size; i++) {
      if (!list.get(i).toString().equals(this.get(i).toString())) {
        return false;
      }
    }

    return true;
  }

  /**
   * returns the item at the specified position in the list.
   * This method first checks if the index requested is valid.
   *
   * @param index index
   * @return result
   */
  @Override
  public E get(int index) {
    // checks if the index requested is valid.
    checkIndex(index);

    for (int i = 0; i < Size; i++) {
      if (i == index) {
        return array[i];
      }
    }

    return null;
  }

  /**
   * searches for a specific item within the linked structure
   * and returns the first occurrence (i.e. index location) in the array if found,
   * otherwise returns -1 to indicate that the item was NOT FOUND.
   *
   * @param item item
   * @return result
   */
  @Override
  public int indexOf(E item) {

    for (int i = 0; i < Size; i++) {
      if (array[i].toString().equals(item.toString())) {
        return i;
      }
    }

    // returns -1 to indicate that the item was NOT FOUND.
    return -1;
  }

  /**
   * returns true, if the list is empty, i.e., the list contains no elements.
   *
   * @return result
   */
  @Override
  public boolean isEmpty() {
    return this.Size == 0;
  }

  /**
   * removes the first occurrence of the item specified from the list,
   * if present. Shifts subsequent elements to the left and returns true,
   * if the item is removed. Reduces the number of elements by one.
   *
   * @param index index
   * @return result
   */
  @Override
  public E remove(int index) {
    checkIndex(index);

    E ret = array[index];

    shiftLeft(index);

    return ret;
  }


  /**
   * removes the item at the given index in the list.
   * Shifts subsequent elements to the left and returns the item removed.
   * This method first checks if the index requested is
   * valid and reduces the number of elements by one.
   *
   * @param item item
   * @return result
   */
  @Override
  public boolean remove(E item) {
    int index = -1;
    for (int i = 0; i < Size; i++) {
      if (array[i].toString().equals(item.toString())) {
        index = i;
        break;
      }
    }

    if (index != -1) {
      remove(index);
      return true;
    } else {
      return false;
    }
  }

  /**
   * replaces the item at the specified position with the one specified.
   * This method validates the index before replacing the item.
   *
   * @param index index
   * @param item  item
   * @return result
   */
  @Override
  public E set(int index, E item) {
    checkIndex(index);

    E old = null;

    for (int i = 0; i < Size; i++) {
      if (i == index) {
        old = array[i];
        array[i] = item;
      }
    }

    return old;
  }

  /**
   * returns the number of elements in the list.
   * This is the Size of the occupied locations of the array.
   *
   * @return result
   */
  @Override
  public int size() {
    return Size;
  }

  /**
   * displays the contents of the list.
   *
   * @return result
   */
  public String toString() {
    if (isEmpty()) {
      return "[]";
    } else {
      StringBuilder result = new StringBuilder("[" + array[0]);
      for (int i = 1; i < Size; i++) {
        result.append(", ").append(array[i]);
      }
      return result.append("]").toString();
    }
  }

  /**
   * helper method that shifts elements of internal array left to index location.
   * Does not update the size of the list.
   *
   * @param index index
   */
  @SuppressWarnings("unchecked")
  private void shiftLeft(int index) {

    for (int i = index + 1; i < Size; i++) {
      array[i - 1] = array[i];
    }
    Size--;

    array[Size] = null;
    if (Size == array.length / 4 && array.length / 2 != 0) {
      E[] newData = (E[]) new Object[array.length / 2];
      for (int i = 0; i < Size; i++) {
        newData[i] = array[i];
      }
      array = newData;
    }
  }

  /**
   * helper method that shifts elements of internal array right from
   * index location. Does not update the size of the list.
   *
   * @param index index
   */
  private void shiftRight(int index) {
    for (int i = Size - 1; i >= index; i--) {
      array[i + 1] = array[i];
    }
  }

  /**
   * adds the item as the first element in the list.
   *
   * @param item item
   */
  public void addFirst(E item) {
    this.add(0, item);
  }

  /**
   * adds the item as the last element in the list.
   *
   * @param item item
   */
  public void addLast(E item) {
    this.add(Size, item);
  }

  /**
   * retrieves the first item in the list.
   *
   * @return result
   */
  public E getFirst() {
    if (this.Size == 0) {
      throw new NoSuchElementException();
    }

    return this.get(0);
  }

  /**
   * retrieves the last item in the list.
   *
   * @return result
   */
  public E getLast() {
    if (this.Size == 0) {
      throw new NoSuchElementException();
    }

    return this.get(size() - 1);
  }

  /**
   * removes the first item from the list.
   *
   * @return result
   */
  public E removeFirst() {
    if (this.Size == 0) {
      throw new NoSuchElementException();
    }

    return this.remove(0);
  }

  /**
   * removes the last item from the list.
   *
   * @return result
   */
  public E removeLast() {
    if (this.Size == 0) {
      throw new NoSuchElementException();
    }

    return this.remove(size() - 1);
  }
}
