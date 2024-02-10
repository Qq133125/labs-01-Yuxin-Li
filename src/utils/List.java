package utils;

/**
 * Interface declaration of the list.
 * @param <E> param
 */
public interface List<E> {

  /**
   * appends the item specified to the end of the list and updates the
   * number of elements one at a time. This method returns true,
   * if the data was added successfully.
   *
   * @param item item
   * @return result
   */
  boolean add(E item);

  /**
   * inserts the item specified at the given index in the list.
   * Shifts subsequent elements to the right and updates the number
   * of elements in list one at a time.
   *
   * @param index index
   * @param item item
   */
  void add(int index, E item);

  /**
   * appends the list specified to the end of the list and updates
   * the number of elements. This method returns true,
   * if the data was added successfully.
   *
   * @param otherList otherList
   * @return result
   */
  boolean addAll(List<E> otherList);

  /**
   * clears list of all elements for garbage collection,
   * returns size back to zero.
   */
  void clear();

  /**
   * searches for a specific value within the
   * internal array and returns true, if the value is in the list.
   *
   * @param item item
   * @return result
   */
  boolean contains(E item);

  /**
   * returns the item at the specified position in
   * the list. This method first checks if the
   * index requested is valid.
   *
   * @param index index
   * @return result
   */
  E get(int index);

  /**
   * searches for a specific item within the linked structure
   * and returns the first occurrence (i.e. index location) in the
   * array if found, otherwise returns -1 to indicate that the item was NOT FOUND.
   *
   * @param item item
   * @return result
   */
  int indexOf(E item);

  /**
   * returns true, if the list is empty, i.e.,
   * the list contains no elements.
   *
   * @return result
   */
  boolean isEmpty();

  /**
   * removes the first occurrence of the item specified from the list,
   * if present. Shifts subsequent elements to the left and returns true,
   * if the item is removed. Reduces the number of elements by one.
   *
   * @param index index
   * @return result
   */
  E remove(int index);


  /**
   * removes the item at the given index in the list.
   * Shifts subsequent elements to the left and returns the item removed.
   * This method first checks if the index requested is valid and
   * reduces the number of elements by one.
   *
   * @param item item
   * @return result
   */
  boolean remove(E item);

  /**
   * replaces the item at the specified position with the one specified.
   * This method validates the index before replacing the item.
   *
   * @param index index
   * @param item item
   * @return result
   */
  E set(int index, E item);

  /**
   * returns the number of elements in the list.
   * This is the size of the occupied locations of the array.
   *
   * @return result
   */
  int size();

  /**
   * adds the item as the first element in the list.
   * @param item item
   */
  void addFirst(E item);

  /**
   * adds the item as the last element in the list.
   * @param item item
   */
  void addLast(E item);

  /**
   * retrieves the first item in the list.
   * @return result
   */
  E getFirst();

  /**
   * retrieves the last item in the list.
   * @return result
   */
  E getLast();

  /**
   * removes the first item from the list.
   * @return result
   */
  E removeFirst();

  /**
   * removes the last item from the list.
   * @return
   */
  E removeLast();
}
