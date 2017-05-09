package de.hfu;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
	@Test
	public void testEnqueueDequeue() {
		Queue queue = new Queue(3);
		
		final int queue_wert_1 = 1;
		final int queue_wert_2 = 2;
		
		queue.enqueue(queue_wert_1);
		queue.enqueue(queue_wert_2);
		
		assertEquals(queue_wert_1, queue.dequeue());
		assertEquals(queue_wert_2, queue.dequeue());
	}
	
	@Test
	public void testEnqueueOverflow() {
		Queue queue = new Queue(3);
		
		final int queue_wert_1 = 1;
		final int queue_wert_2 = 2;
		final int queue_wert_3 = 3;
		final int queue_wert_4 = 4;
		
		queue.enqueue(queue_wert_1);
		queue.enqueue(queue_wert_2);
		queue.enqueue(queue_wert_3);
		queue.enqueue(queue_wert_4);
		
		assertEquals(queue_wert_1, queue.dequeue());
		assertEquals(queue_wert_2, queue.dequeue());
		assertEquals(queue_wert_4, queue.dequeue());
	}
	
	@Test(expected=IllegalStateException.class)
	public void testDequeueEmptyQueue() {
		Queue queue = new Queue(3);
		queue.dequeue();
	}
}
