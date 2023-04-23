package p1;

import java.util.*;

public class SGHeap<T extends Comparable<T>> implements SGQueue<T>{
	public static void main(String[]args) {
		SGHeap<String> songHeap = new SGHeap<>();
		//add 20 song manually
		songHeap.addSong("Monogomy");
		songHeap.addSong("Mice");
		songHeap.addSong("Sidelines");
		songHeap.addSong("Killer");
		songHeap.addSong("Olympus");
		songHeap.addSong("Please Stay");
		songHeap.addSong("Ceilings");
		songHeap.addSong("End of Beginning");
		songHeap.addSong("I Wish I Never Met You");
		songHeap.addSong("Two Weeks");
		songHeap.addSong("Toxic");
		songHeap.addSong("Andromeda");
		songHeap.addSong("Bite the Hand");
		songHeap.addSong("Happier Than Ever");
		songHeap.addSong("Zombie");
		songHeap.addSong("Colors");
		songHeap.addSong("Buzzcut Season");
		songHeap.addSong("Sofia");
		songHeap.addSong("Ameoba");
		songHeap.addSong("I'm Not In Love");
		
		while (!songHeap.isEmpty()) {
			System.out.println(songHeap.peekSong());
			songHeap.removeSong();
		}
	}
	
	private ArrayList<T> data;
	public SGHeap() {
		
	}
	public void addSong(T song) {
		data.add(song);
		int index = data.size()-1;
		while(index > 0 && data.get(parent(index)).compareTo(data.get(index))< 0);
			swap(index, parent(index));
			index = parent(index);
	}
	public void deleteAll() {
		data.clear();
	}
	public boolean isEmpty() {
		return data.isEmpty();
	}
	public T peekSong() {
		if (isEmpty()) {
			return null;
		}
		return data.get(0);
	}
	public void pushSong(T song) {
		addSong(song);
	}
	public T removeSong() {
		if (isEmpty()) {
			return null;
		}
		T root = data.get(0);
		data.set(0,data.get(data.size()-1));
		heapify(0);
		return root;
	}
	public int size() {
		return data.size();
	}
	private void heapify(int index) {
		int left = leftChild(index);
		int right = rightChild(index);
		int largest = index;
		if (left < data.size() && data.get(left).compareTo(data.get(largest))>0) {
			largest = left;
		}
		if (right < data.size() && data.get(right).compareTo(data.get(largest))>0) {
			largest = right;
		}
		if(largest!= index) {
			swap(index,largest);
			heapify(largest);
		}
	
	}
	private int parent(int index){
		return (index -1)/2;
	}
	private int leftChild(int index) {
		return 2* index + 1;
	}
	
	private void swap(int i, int j) {
		T tmp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, tmp);
	}


	private int rightChild(int index) {
		return 2 * index + 2;
	}
	
	
}
	