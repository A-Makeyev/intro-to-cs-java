public class Ex14 {

    /* 1 */

     // Complexity: O(n)
    private static boolean isDoubleBigger(int index, int [] arr, int Double, int odd) {
        if (index >= arr.length)
            return (Double > odd);

        if (index % 2 == 0) {
            return (isDoubleBigger(index + 1, arr, Double + arr[index], odd));
        }
        return (isDoubleBigger(index + 1, arr, Double, odd + arr[index]));
    }

    // Complexity: 2^n + n -> 2^n
    public static void win (int [] arr) {
        // Time complexity: O(n)
        boolean doDouble = isDoubleBigger(0, arr, 0, 0);
        // // Time complexity: 2^n
        win(arr, 0, arr.length - 1, doDouble, 0, 0);
    }


    // Complexity: 2^n
    private static void win (int [] arr, int left, int right, boolean doDouble, int amir, int tamar) {
        if (left > right) {
            System.out.println("Final Score:\nAmir's total: " + amir + "\nTamar's total: " + tamar);
            return;
        }

        if ((left + right) % 2 != 0) {
            if (doDouble && left % 2 == 0 || !doDouble && left % 2 != 0) {
                System.out.println("Amir took " + arr[left]);
                amir += arr[left];
                left++;
                win(arr, left, right, doDouble, amir, tamar);
            } else {
                System.out.println("Amir took " + arr[right]);
                amir += arr[right];
                right--;
                win(arr, left, right, doDouble, amir, tamar);
            }
        } else {
            if (arr[left] > arr[right]) {
                System.out.println("Tamar took " + arr[left]);
                tamar += arr[left];
                left++;
                win(arr, left, right, doDouble, amir, tamar);
            } else {
                System.out.println("Tamar took " + arr[right]);
                tamar += arr[right];
                right--;
                win(arr, left, right, doDouble, amir, tamar);
            }
        }
    }


    /* 2 */

    // Complexity: O(n)
    private static int numberOfNegatives(int [] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 0){
                sum ++;
            }
        }
        return sum;
    }

    private static void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Complexity: O(n)
    public static int findTriplet (int [] arr) {
        if(arr.length == 3) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
            return (arr[0] * arr[1] * arr[2]);
        }

        int negative = numberOfNegatives(arr), result = 0;

        if (negative == arr.length) {
            result = findSmallest(arr);
        } else {
            result = findBiggest(arr);
        }
        return result;
    }


    // Time complexity: O(n)
    private static int findSmallest(int [] arr) {
        int [] index = {0, 1, 2};

        //  Complexity: O(3) = O(1)
        index = sortIndexArray(arr, index);
        swap(index, 0, 2);

        //  Complexity: O(n)
        for (int i = 3; i < arr.length; i++) {
            if (Math.abs(arr[i]) < Math.abs(arr[index[0]])) {
                index[2] = index[1];
                index[1] = index[0];
                index[0] = i;
            } else if (Math.abs(arr[i]) < Math.abs(arr[index[1]])) {
                index[2] = index[1];
                index[1] = i;
            } else if (Math.abs(arr[i]) < Math.abs(arr[index[2]])) {
                index[2] = i;
            }
        }

        System.out.println(arr[index[0]] + " " + arr[index[1]] + " " + arr[index[2]]);
        return (arr[index[0]] * arr[index[1]] * arr[index[2]]);
    }


    // Complexity: O(n)
    private static int findBiggest(int [] arr) {
        int [] index = {0, 1, 2};

        // Complexity: O(3) = O(1)
        index = sortIndexArray(arr, index);
        int highPositive = -1, highNegative = 1;

        // Time complexity: O(n)
        for (int i = 3; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(arr[index[0]])) {
                if (arr[index[2]] > highPositive) {
                    highPositive = arr[index[2]];
                } else if (arr[index[2]] < highNegative) {
                    highNegative = arr[index[2]];
                }

                index[2] = index[1];
                index[1] = index[0];
                index[0] = i;

            } else if (Math.abs(arr[i]) > Math.abs(arr[index[1]])) {
                if (arr[index[2]] > highPositive) {
                    highPositive = arr[index[2]];
                } else if (arr[index[2]] < highNegative) {
                    highNegative = arr[index[2]];
                }

                index[2] = index[1];
                index[1] = i;

            } else if (Math.abs(arr[i]) > Math.abs(arr[index[2]])) {
                if (arr[index[2]] > highPositive) {
                    highPositive = arr[index[2]];
                } else if (arr[index[2]] < highNegative) {
                    highNegative = arr[index[2]];
                }

                index[2] = i;

            } else if (arr[i] > highPositive) {
                highPositive = arr[i];
            } else if (arr[i] < highNegative) {
                highNegative = arr[i];
            }
        }

        int [] result = {arr[index[0]], arr[index[1]], arr[index[2]]};
        int negativeNum = numberOfNegatives(result);
        if (negativeNum == 3) {
            result[2] = highPositive;
        } else if (negativeNum == 1) {
            if (result[0] < 0) {
                if (highPositive * result[1] * result[2] > result[0] * result[1] * highNegative) {
                    result[0] = highPositive;
                } else {
                    result[2] = highNegative;
                }
            } else if (result[1] < 0) {
                if (result[0] * highPositive * result[2] > result[0] * result[1] * highNegative) {
                    result[1] = highPositive;
                } else {
                    result[2] = highNegative;
                }
            } else {
                if (result[0] * result[1] * highPositive > result[0] * highNegative * result[2]) {
                    result[2] = highPositive;
                } else {
                    result[1] = highNegative;
                }
            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
        return (result[0] * result[1] * result[2]);
    }

    // Complexity: O(1)
    private static int [] sortIndexArray(int [] arr, int [] index) {
        if(Math.abs(arr[index[0]]) < Math.abs(arr[index[1]])) {
            swap(index, 0, 1);
        }
        if(Math.abs(arr[index[0]]) < Math.abs(arr[index[2]])) {
            swap(index, 0, 2);
        }
        if(Math.abs(arr[index[1]]) < Math.abs(arr[index[2]])) {
            swap(index, 1, 2);
        }
        return index;
    }

    /* 3 */

    // Complexity: 2^n
    public static int count (String str, String pattern) {
        return count(str, pattern, 0, 0);
    }

    // Complexity: 2^n
    private static int count (String str, String pattern, int strIndx, int patternIndx) {
        if (patternIndx == pattern.length())
            return 1;
        if (strIndx >= str.length())
            return 0;

        int count = 0;

        if (str.charAt(strIndx) == pattern.charAt(patternIndx)) {
            count += count(str, pattern, strIndx + 1, patternIndx);
            patternIndx++;
        }
        return count(str, pattern, strIndx + 1, patternIndx) + count;
    }

    /* 4 */

    // Complexity: 4^n
    public static int prince(int[][] digitalMap, int i, int j) {
        return (prince(digitalMap, i, j, 1));
    }

    // Complexity: O(1)
    private static int minOfFour(int a1, int a2, int a3, int a4) {
        int min = a1;

        if (min < 0 || (a2 > 0 && a2 < min))
            min = a2;

        if (min < 0 || (a3 > 0 && a3 < min))
            min = a3;

        if (min < 0 || (a4 > 0 && a4 < min))
            min = a4;

        return min;
    }

    // Complexity: 4^n
    private static int prince(int[][] digitalMap, int princeX, int princeY, int count) {
        if (princeX < 0 || princeY < 0 || princeX >= digitalMap.length || princeY >= digitalMap[princeX].length || digitalMap[princeX][princeY] == -10)
            return -1;

        if(digitalMap[princeX][princeY] == -1)
            return count;

        int princeHigh = digitalMap[princeX][princeY];
        digitalMap[princeX][princeY] = -10;

        int a1 = -1, a2 = -1, a3 = -1, a4 = -1;

        if (canMoveTo(digitalMap, princeX - 1, princeY, princeHigh))
            a1 = prince(digitalMap, princeX - 1, princeY, count + 1);
        if (canMoveTo(digitalMap, princeX + 1, princeY, princeHigh))
            a2 = prince(digitalMap, princeX + 1, princeY, count + 1);
        if (canMoveTo(digitalMap, princeX, princeY + 1, princeHigh))
            a3 = prince(digitalMap, princeX, princeY + 1, count + 1);
        if (canMoveTo(digitalMap, princeX, princeY - 1, princeHigh))
            a4 = prince(digitalMap, princeX, princeY - 1, count + 1);

        int res = minOfFour(a1, a2, a3, a4);

        digitalMap[princeX][princeY] = princeHigh;

        return res;
    }

    // Complexity: O(1)
    private static boolean canMoveTo(int[][] digitalMap, int destX, int destY, int princeHigh) {
        if (destX < 0 || destY < 0 || destX >= digitalMap.length || destY >= digitalMap[destX].length)
            return false;

        int destHigh = digitalMap[destX][destY];

        if (destHigh == -1)
            return true;

        int difference = princeHigh - destHigh;

        return (difference >= -1 && difference <=2) ;
    }

}
