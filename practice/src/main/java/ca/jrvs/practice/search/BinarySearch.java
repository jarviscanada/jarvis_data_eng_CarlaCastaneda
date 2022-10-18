package ca.jrvs.practice.search;

import java.util.Arrays;
import java.util.Optional;

public class BinarySearch {

    /**
     * find the the target index in a sorted array
     *
     * @param arr input arry is sorted
     * @param target value to be searched
     * @return target index or Optional.empty() if not ound
     */
    public <E> Optional<Integer> binarySearchRecursion(E[] arr, E target) {
        int min=0;
        int max=arr.length;
        int mid = (max+min)/2;


        if (arr[mid].equals(target)){
            return Optional.of(Integer.valueOf(mid));
        } else if (arr[mid].hashCode()<target.hashCode()){
                return binarySearchRecursion(Arrays.copyOfRange(arr, min, mid),target);

            }
            else if(arr[mid].hashCode()>target.hashCode()){
                return binarySearchRecursion(Arrays.copyOfRange(arr, mid, max),target);

            }

        else{
            return Optional.empty();
        }




    }

    /**
     * find the the target index in a sorted array
     *
     * @param arr input arry is sorted
     * @param target value to be searched
     * @return target index or Optional.empty() if not ound
     */
    public <E> Optional<Integer> binarySearchIteration(E[] arr, E target) {
        int min=0;
        int max=arr.length;
        int mid = (min+max)/2;

        boolean found_index=false;

        while (found_index!=true){
            if (arr[mid]== target){
                found_index=true;
                return Optional.of(mid);
            }
            else if(arr[mid].hashCode()>target.hashCode()){
                max=mid;

            }
            else if (arr[mid].hashCode()<target.hashCode()){
                min=mid;


            }

        }


        return Optional.empty();
    }
}