package dsa.leetcode.array;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 6 };
		int target = 5;

		int position = new SearchInsertPosition().searchInsertPosition(arr, target);
		System.out.println(position);
	}

	public int searchInsertPosition(int[] arr, int target) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				num = i;
				break;
			} else if (target <= arr[i]) {
				num = i;
				break;
			} else if (target > arr[i]) {
				num = i + 1;
			}

		}
		return num;
	}
}
