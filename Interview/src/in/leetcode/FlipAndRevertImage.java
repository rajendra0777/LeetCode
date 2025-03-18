package in.leetcode;

/*
 * Problem: Leetcode Interview assesment (832 Flipping an Image)
 * Solution:https://leetcode.com/problems/flipping-an-image/submissions/
 */

public class FlipAndRevertImage {
	public static void main(String[] args) {
		int[][] image = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };

		int[][] flip = new FlipAndRevertImage().flipAndInvertImage(image);

		for (int[] i : image) {
			for (int a : i) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}

	public int[][] flipAndInvertImage(int[][] image) {

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length / 2; j++) {

				int temp = image[i][j];
				image[i][j] = image[i][image[i].length - j - 1];
				image[i][image[i].length - j - 1] = temp;
			}
		}

		for (int k = 0; k < image.length; k++) {
			for (int l = 0; l < image[k].length; l++) {
				if (image[k][l] == 1) {
					image[k][l] = 0;
				} else {
					image[k][l] = 1;
				}
			}
		}

		return image;

	}
}
