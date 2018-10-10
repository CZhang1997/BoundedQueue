//		Churong Zhang
//		CS 3345.004. Data structures and algorithm analysis
//		Fall 2018
//		Intensive Track Assignment 2.1
//		Sept 16, 2018


package cxz173430;



	public class BoundedQueue<T>
	{
		// instance field 
		private Object[] queue;
		private int head;
		private int tail;
		
		
		public BoundedQueue(int size)
		{
			queue = new Object[size];
			head = 0;
			tail = 0;
			
		}
		public boolean offer(T x)
		{
			if(tail - head == queue.length)
				return false;
			queue[tail % queue.length] = x;
			tail++;
			return true;
		}
		public Object poll()
		{
			if(isEmpty())
				return null;
			head++;
			return queue[(head-1)%queue.length];
		}
		public Object peek()
		{
			if(isEmpty())
				return null;
			return queue[head % queue.length];
		}
		public int size()
		{
			return tail - head;
		}
		public boolean isEmpty()
		{
			return head == tail;
		}
		public void clear()
		{
			head = tail = 0;
			
		}
		public void toArray(Object [] a )
		{
			
			int i = 0;
			int end = tail-1;
			while(head <= end && i < a.length)
			{
				a[i] = poll();
				// restore it;
				offer((T)a[i]);
				i++;
			}
			while(head <= end)
			{
				offer((T)poll());
				i++;
			}
			// use the one below if we do not want to restore it.
			/*
			int i = 0;
			while(!isEmpty() && i < a.length)
			{
				a[i] = poll();
				i++;
			}
			*/
		}
	
	public static void main(String[] args) {
		/*
		BoundedQueue queue = new BoundedQueue(5);
		queue.offer("Hi");
		queue.offer(5);
		queue.offer("Are");
		queue.offer("you");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		*/
		
		BoundedQueue<Integer> queue = new BoundedQueue<>(12);

		int items = 12;
		for(int a = 0; a < items; a++ )
		{
			if(!queue.offer(a))
			{
				System.out.println(a + " is not added to the queue");
				//System.out.println("Size is " + queue.size + " start is "+ queue.start + " end is " + queue.end);
			}
				
		}
		
		System.out.println(queue.peek() + " is at the top.");
		System.out.println(queue.poll() + " is remove");
		//while(!queue.isEmpty())
			//System.out.println(queue.poll() + " is remove");
		//System.out.println(queue.poll() + " is remove");
		Object[] list = new Object[10];
		/*
		for(int a= 0; a < list.length; a++)
		{
			list[a] = (int) (Math.random()* 50);
		}*/
		queue.toArray(list);
		for(int a = 0; a< 10; a++)
		{
			System.out.print((Integer)list[a] + " ");
		}
		System.out.println("");
		
		System.out.println(queue.poll() + " is remove");
		//System.out.println(list[5]+ " is here");
		while(!queue.isEmpty())
			System.out.println(queue.poll() + " is remove");
		
	}
		
		
}


