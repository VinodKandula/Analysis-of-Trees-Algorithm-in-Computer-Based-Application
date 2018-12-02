
import java.util.Random;

public class HeapSortTest
{
	public int[] myArray;
	public int heapSize;

	public HeapSortTest(int size)
	{
		if( size > 0 )
		{
			myArray = new int[size];
		}
		else
		{
			myArray = new int[10];
		}
	}

	public void initializeArrayWithRandomNumbers()
	{
		Random random = new Random();

		for( int i = 0; i < myArray.length; i++ )
		{
			myArray[i] = random.nextInt(50);
		}
	}

	public void displayArrayContents()
	{
		for( int number : myArray )
		{
			System.out.print(number + " ");
		}
		System.out.println();
	}

	public void maxHeapify(int size, int i)
	{
		int left;
		int right;
		int largest;

		if( i < 0 || i > (size - 1) )
		{
			return;
		}

		left = ((2 * i) + 1);
		right = ((2 * i) + 2);

		largest = i;

		if( left < heapSize && myArray[left] > myArray[largest] )
		{
			largest = left;
		}
		if( right < heapSize && myArray[right] > myArray[largest] )
		{
			largest = right;
		}

		if( largest != i )
		{
			int temp = myArray[i];
			myArray[i] = myArray[largest];
			myArray[largest] = temp;

			maxHeapify(size, largest);
		}
	}

	public void buildMaxHeap(int size)
	{
		for( int i = ((size - 1) / 2); i >= 0; i-- )
		{
			maxHeapify(size, i);
		}
	}

	public void heapSortAscendingOrder(int size)
	{
		buildMaxHeap(size);

		int temp;

		for( int i = (size - 1); i > 0; i-- )
		{
			temp = myArray[0];
			myArray[0] = myArray[i];
			myArray[i] = temp;

			heapSize--;

			maxHeapify(size, 0);
		}
	}

	public static void main(String[] args)
	{
		HeapSortTest h = new HeapSortTest(20);

		h.initializeArrayWithRandomNumbers();

		System.out.println("Before Sorting:");
		h.displayArrayContents();

		h.heapSize = h.myArray.length;
		h.heapSortAscendingOrder(h.myArray.length);

		System.out.println("After Sorting:");
		h.displayArrayContents();
	}
}
