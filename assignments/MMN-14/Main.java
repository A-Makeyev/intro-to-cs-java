public class Main {
    public static void main(String[] args) {
        System.out.println("\n------------------------------------\nTesting Question 1\n------------------------------------\n");
        System.out.println("Test for input: {16, 23, 30, 13, 14, 21, 19, 15}\n");
 
        int[] coins1 = {16, 23, 30, 13, 14, 21, 19, 15};
        Ex14.win(coins1);

        System.out.println("\n------------------------------------\nTesting Question 2\n------------------------------------\n");
        System.out.println("Test for input: {-4,1,-8,9,6}\n");

        int[] arr = {-4, 1, -8, 9, 6};
        int result = Ex14.findTriplet (arr);

        System.out.println("\nfindTriplet return value is: " + result);
        System.out.println("\n(Remark to students - Note that the order of the printed numbers is not important)");

        System.out.println("\n------------------------------------\nTesting Question 3\n------------------------------------\n");
        result = Ex14.count ("subsequence","sue");

        System.out.println("count(\"subsequence\",\"sue\") return value is: " + result);

        System.out.println("\n------------------------------------\nTesting Question 4\n------------------------------------\n");
        System.out.println("Test for input:");
        System.out.println("\t {{2,0,1,2,3},");
        System.out.println("\t {2,3,5,5,4},");
        System.out.println("\t {8,-1,6,8,7},");
        System.out.println("\t {3,4,7,2,4},");
        System.out.println("\t {2,4,3,1,2}}");

        int[][] drm = {
	        {2, 0, 1, 2, 3},
	        {2, 3, 5, 5, 4},
	        {8, -1, 6, 8, 7},
	        {3, 4,7, 2, 4},
	        {2, 4, 3, 1, 2}
        };

        result = Ex14.prince (drm, 0, 0);

        System.out.println("\nprince (drm,0,0) return value is: " + result);

        result = Ex14.prince (drm, 4, 4);

        System.out.println("\nprince (drm,4,4) return value is: " + result);
    }

}
