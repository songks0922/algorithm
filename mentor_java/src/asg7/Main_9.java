package asg7;

public class Main_9 {
    public static int[][] solution(int[][] nums) {
        int[][] answer = new int[nums.length][nums.length];

        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if(i==0 && j==0) {
                    if(nums[i][j] == nums[i+1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j+1]) {
                        answer[i][j] = 0;
                    } else {
                        answer[i][j] = nums[i][j];
                    }
                } else if(i==0 && j==nums.length-1) {
                    if(nums[i][j] == nums[i+1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j-1]) {
                        answer[i][j] = 0;
                    } else {
                        answer[i][j] = nums[i][j];
                    }
                } else if(i==nums.length-1 && j==0) {
                    if(nums[i][j] == nums[i-1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j+1]) {
                        answer[i][j] = 0;
                    } else {
                        answer[i][j] = nums[i][j];
                    }
                } else if(i==nums.length-1 && j==nums.length-1) {
                    if(nums[i][j] == nums[i-1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j-1]) {
                        answer[i][j] = 0;
                    } else {
                        answer[i][j] = nums[i][j];
                    }
                } else if(i==0 && j>0 && j<nums.length-1) {
                    if(nums[i][j] == nums[i+1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j-1]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j+1]) {
                        answer[i][j] = 0;
                    } else {
                        answer[i][j] = nums[i][j];
                    }
                } else if(i==nums.length-1 && j>0 && j<nums.length-1) {
                    if(nums[i][j] == nums[i-1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j-1]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j+1]) {
                        answer[i][j] = 0;
                    } else {
                        answer[i][j] = nums[i][j];
                    }
                } else if(i>0 && i<nums.length-1 && j==0) {
                    if(nums[i][j] == nums[i-1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i+1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j+1]) {
                        answer[i][j] = 0;
                    } else {
                        answer[i][j] = nums[i][j];
                    }
                } else if(i>0 && i<nums.length-1 && j==nums.length-1) {
                    if(nums[i][j] == nums[i-1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i+1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j-1]) {
                        answer[i][j] = 0;
                    } else {
                        answer[i][j] = nums[i][j];
                    }
                } else if(i>0 && i<nums.length-1 && j>0 && j<nums.length-1) {
                    if(nums[i][j] == nums[i-1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i+1][j]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j-1]) {
                        answer[i][j] = 0;
                    } else if(nums[i][j] == nums[i][j+1]) {
                        answer[i][j] = 0;
                    } else {
                        answer[i][j] = nums[i][j];
                    }
                } else {
                    answer[i][j] = nums[i][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 4, 4, 4},
                {1, 5, 3, 4, 3},
                {1, 4, 1, 1, 4},
                {1, 2, 3, 1, 3},
                {1, 1, 1, 1, 2}
        };
        int answer[][] = solution(nums);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
