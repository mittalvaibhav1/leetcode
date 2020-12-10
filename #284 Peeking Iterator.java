//https://leetcode.com/problems/peeking-iterator/
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
//M1
class PeekingIterator implements Iterator<Integer> {
    LinkedList<Integer> q = new LinkedList<>();
	public PeekingIterator(Iterator<Integer> iterator) {
        while(iterator.hasNext()) {
            q.add(iterator.next());
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return q.peek();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        return q.poll();
	}
	
	@Override
	public boolean hasNext() {
	    return !q.isEmpty();
	}
}
// M2
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    boolean  done;
    Integer next;
	public PeekingIterator(Iterator<Integer> iterator) {
        this.it = iterator;
        if(it.hasNext()) {
            next = it.next();
        }
        else {
            done = true;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = next;
        if(it.hasNext()) {
            next = it.next();
        }
        else {
            next = null;
            done = true;
        }
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return !done;
	}
}