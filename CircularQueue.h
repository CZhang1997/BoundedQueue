#ifndef CIRCULAR_QUEUE_H
#define CIRCULAR_QUEUE_H

class CircularQueue
{
public:
	CircularQueue();
	CircularQueue(int);
	~CircularQueue();
	int deque();
	void que(int);
	int getHead();
	int getTail();
	bool isEmpty();
private:
	int list[100];
	int MaxSize;
	int head;
	int tail;
};

CircularQueue::CircularQueue()
{
	MaxSize = 10;
	list[MaxSize];
	
	head = 0;
	tail = 0;
}
CircularQueue::CircularQueue(int siz)
{
	MaxSize = siz;
	list[MaxSize];

	head = 0;
	tail = 0;
}
CircularQueue::~CircularQueue()
{
	
}
bool CircularQueue::isEmpty()
{
	return head == tail;
}
int CircularQueue::deque()
{
	if (tail == head)
	{
		cout << "Nothing in the queue" << endl;
		return 0;
	}

	head++;
	return list[(head-1)%MaxSize];

}
void CircularQueue::que(int v)
{
	if (tail - head == MaxSize)
	{
		cout << "The queue is full." << endl;
	}
	else
	{
		list[tail % MaxSize] = v;
		tail++;
	}

}

int CircularQueue::getHead()
{
	if (!isEmpty())
		return list[head];
	else
		return 0;

}

int CircularQueue::getTail()
{
	if (!isEmpty())
		return list[tail-1];
	else
		return 0;
}

#endif // !CIRCULAR_QUEUE_H

