package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;

public class TwoSum {

  /**
   * Big-O: O(n^2)
   * Justification: nested for loop
   */
  public int[] twoSum(int [] arrayInt,int target){

    int[] result= new int[2];

    for (int i=0;i<arrayInt.length;i++){
      for (int n=i+1;n<arrayInt.length;n++){

        if ((arrayInt[i]+arrayInt[n])==target){
          result[0]=i;
          result[1]= n;
          return result;
        }
      }

    }
    return result;

  }

  /**
   * Big-O: O(n)
   * Justification: for loop O(n) with O(1) map operations such as containskey and put functions
   */

  public int[] twoSumHashMap(int [] nums,int target){
    int [] result= new int[2];
    HashMap hashMap= new HashMap();

    for (int i=0;i<nums.length;i++){
      if (!hashMap.containsKey(nums[i])){
        hashMap.put(nums[i],i);



      }
      int complement= target-nums[i];

      if (hashMap.containsKey(complement) && (hashMap.get(complement)!= hashMap.get(nums[i]))){

        result[0]=i;
        result[1]= (int) hashMap.get(complement);
//        System.out.println( "object"+hashMap.get(complement));
        break;

      }



    }
    return result;



  }





}
