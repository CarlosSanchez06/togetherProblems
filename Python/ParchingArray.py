# Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.
# Return the minimum number of patches required.
from typing import List


class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        patch = 0
        maxPosible = 0
        while (maxPosible < n):
            if ( not self.verify(nums,maxPosible+1)):
                patch= patch + 1 
                nums.append(maxPosible+1)
                nums = sorted(nums)
                maxPosible = maxPosible + maxPosible + 1
            else:
                index = self.getMax(nums,maxPosible+1)
                maxPosible = maxPosible + nums[index]
        return patch

    def getMax(self, nums, n):
        i=len(nums)-1
        while(i>=0 and nums[i])>n:
            i= i - 1
        if (i<0):
            return -1
        return i

    def verify (self,list, number):
        listaClonada = list.copy()
        while (number>0):
            max = self.getMax(listaClonada, number)
            if (max < 0):
                return False
            else:
                number -= listaClonada[max]
                listaClonada.pop(max)
        return True