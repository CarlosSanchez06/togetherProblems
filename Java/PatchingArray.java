// Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.
// Return the minimum number of patches required. LeetCode-330
import java.util.*;
import java.util.stream.Collectors;

public class PatchingArray{
    public int minPatches(int[] nums, int n) {
        
        List<Integer> list = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList());

        int patch = 0;
        int maxPosible = 0;
        while (maxPosible < n)
        {
            if ( !verify(list,maxPosible+1)){
                patch++;
                list.add(maxPosible+1);
                list.sort((a, b) -> { return a.compareTo(b); } );
                maxPosible = maxPosible + maxPosible + 1;
            }
            else{
                int index = getMax(list,maxPosible+1);
                maxPosible = maxPosible + list.get(index);    
            }
        }
        return patch;
    }


    public int getMax(List<Integer> nums, int n){
        int i=nums.size()-1;
        while(i>=0 && nums.get(i)>n){
            i--;
        }
        if (i<0)
            return -1;
        return i;
    }

    public Boolean verify(List<Integer> list, int number){
        List<Integer> clonedlist = new ArrayList<Integer>(list);
        while (number>0){
            int max = getMax(clonedlist, number);
            if (max < 0){
                return false;
            }else{
                number -= clonedlist.get(max);
                clonedlist.remove(max);
            }
        }
        return true;
    }
}