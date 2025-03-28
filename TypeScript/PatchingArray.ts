// # Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.
// # Return the minimum number of patches required.

function minPatches(nums: number[], n: number): number {
    let patch = 0;
    let maxPosible = 0;
    while (maxPosible < n){
        if (!verify(nums,maxPosible+1)){
            patch= patch + 1 ;
            nums.push(maxPosible+1);
            nums.sort((a, b) => a - b);

            maxPosible = maxPosible + maxPosible + 1;
        }else{
            let index = getMax(nums,maxPosible+1);
            maxPosible = maxPosible + nums[index];
        }
    }
    return patch
}

function getMax(nums:number[], n: number){
    let i=nums.length-1;
    while ((i>=0 && nums[i]>n))
        i= i - 1;
    if (i<0)
        return -1;
    return i
}

function verify(list:number[],  n: number){
    let clonedlist  = [...list];
    while (n>0){
        let max = getMax(clonedlist, n);
        if (max < 0){
            return false;
        }else{
            n -= clonedlist[max];
            clonedlist.splice(max, 1);
        }
    }
    return true;
}