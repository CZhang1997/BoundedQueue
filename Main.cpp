//Churong Zhang
#include<iostream>

using namespace std;

#include"CircularQueue.h"

void main()
{
	//CircularQueue list;
	
	/*int size = 10;
	for(int a = 0; a < size; a++)
	{
		list.que(a+20);
		if(a%2 == 0)
			cout << list.deque() << " ";
	}
	cout << endl;*/
	CircularQueue list (20);

	for (int b = 0; b < 20; b++)
	{
		list.que(b+10);
	}

	while (!list.isEmpty())
	{
		cout << list.deque() << " ";
	}

	cout << endl << list.getHead() << " " << list.getTail() << endl;

	system("pause");
}