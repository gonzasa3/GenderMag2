package p1;

public interface SGQueue<T> {
	//create methods that accept any type of element
	
	void addSong(T song);
	 
	void deleteAll();
	
	boolean isEmpty();
	
	T peekSong();
	
	void pushSong(T song);
		
	int size();
}
