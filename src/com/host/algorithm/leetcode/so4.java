package com.host.algorithm.leetcode;

public class so4 {
    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     *
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * 示例 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int n = nums1.length;
       int m = nums2.length;

       int left = (n+m+1)/2;//要求的中位数
       int right = (n+m+2)/2;
       //将偶数和奇数的情况合并，如果是奇数，会求两次同样的k
       return ((getKth(nums1,0,n-1,nums2,0,m-1,left)
               +getKth(nums1,0,n-1,nums2,0,m-1,right))*0.5);

    }

    /**
     * 求两个有序数组的中位数
     * 两个数组分别折半查找
     * [1,3,4,9]
     * [1,2,3,4,5,6,7,8,9,10]
     * 问题等价于求第七大的数
     * 每个数组都取前面3=7/2个
     * 由于4》3
     * 所以第二个数组[1,2,3]都是最小的去掉后还剩
     * [1,3,4,9]
     * [4,5,6,7,8,9,10]
     * 已经去掉了3个相当于求4=7-3大的数了，每个数组都取前面2=4/2个
     * 3》5
     * 所以第一个数组[1,3]去掉
     * [4,9]
     * [4,5,6,7,8,9,10]
     * 求第2=4-2大的数就是两个数比较了
     * @param nums1
     * @param start1
     * @param end1
     * @param nums2
     * @param start2
     * @param end2
     * @param k
     * @return
     */
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return getKth(nums2,start2,end2,nums1,start1,end1,k);//保证长度小的为第一个
        if (len1 == 0) return nums2[start2+k - 1];
        if (k==1) return Math.min(nums1[start1],nums2[start2]) ;

        int i = start1 + Math.min(len1,k/2)-1;
        int j = start2 + Math.min(len2,k/2)-1;
        if (nums1[i]<nums2[j]){
            return getKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }
        else {
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }
    }
}
