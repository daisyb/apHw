public class array{
  
  public int[] frontPiece(int[] nums) {
    if (nums.length < 2){
       return nums;
    } 
    int[] newArray = new int[2];
    newArray[0] = nums[0];
    newArray[1] = nums[1];
    return newArray;
  }
  
  public int sum13(int[] nums) {
    int sum = 0;
    for(int i = 0;i < nums.length;i++){
       int n = nums[i];
       if (n != 13) {
           if (i == 0){
             sum +=n;
          } else if (nums[i -1] != 13){
             sum += n;
          } 
       }
    }
    return sum;
  }

}
