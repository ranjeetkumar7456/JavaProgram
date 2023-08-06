package ArrayConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeIntegersSumToTarget {
    public static int[] findThreeIntegersSumToTarget(int[] arr, int target) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++)
        {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right)
            {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target)
                {
                    return new int[]
                            {
                                    arr[i], arr[left], arr[right]
                            };
                }
                else if (sum < target)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }

        return null;
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    result.add(triplet);

                    // Skip duplicates to avoid duplicate triplets
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2,6,10,18,14,22,26,30,34,38,42,46,50,58};
        int target = 60;

        int[] result = findThreeIntegersSumToTarget(arr, target);

        if (result != null) {
            System.out.println("Three integers found: " + Arrays.toString(result));
        } else {
            System.out.println("No three integers found in the array that sum to the target.");
        }


        List<List<Integer>> triplets = threeSum(arr, target);

        if (triplets.isEmpty()) {
            System.out.println("No triplets found with the sum of " + target);
        } else {
            System.out.println("Triplets with the sum of " + target + ":");
            for (List<Integer> triplet : triplets) {
                System.out.println(triplet);
            }
        }
    }

}
