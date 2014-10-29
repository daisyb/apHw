public class Codingbat{

    public int sum67(int[] nums) {
	int count = 0;
	boolean six = false;
	for (int i = 0; i < nums.length;i++){
	    int n = nums[i];
	    if (six != true){
		if (n == 6){
		    six = true;
		} else {
		    count += n;
		}
	    } else {
		if (n == 7){
		    six = false;
		}
	    }
	}
	return count;
    }

    public boolean more14(int[] nums) {
	int ones = 0;
	int fours = 0;
	for (int i =0;i < nums.length;i++){
	    int n = nums[i];
	    if (n == 1){
		ones += 1;
	    }
	    if (n == 4){
		fours +=1;
	    }
	}
	if (ones > fours){
	    return true;
	}
	return false;
    }

    public int[] tenRun(int[] nums) {
	int[] tens = new int[nums.length];
	int multiple = 0;
	for (int i = 0;i < nums.length; i++){
	    int n = nums[i];
	    if (multiple == 0 && n%10 != 0){
		tens[i] = n;
	    } else if (n%10 == 0){
		multiple = n;
		tens[i] = n;
	    } else {
		tens[i] = multiple;
	    }
	}
	return tens;
    }

    public boolean tripleUp(int[] nums) {
	if (nums.length < 3){
	    return false;
	}
	for (int i = 2; i < nums.length; i++){
	    int n = nums[i];
	    if (nums[i - 1] == n -1 && nums[i -2] == n -2){
		return true;
	    }
	}
	return false;
    }

    public boolean canBalance(int[] nums) {
	int front = 0;
	int back = 0;
	for (int i =0; i < nums.length;i++){
	    front += nums[i];
	    for (int n = i +1; n < nums.length; n++){
		back += nums[n];
	    }
	    if (front == back){
		return true;
	    }
	    back = 0;
	}
	return false;
    }

    //not working
    public int[] seriesUp(int n) {
        int[] ans = new int[n*(n + 1)/2];
	int count = 1;
	for (int i = 0; i < ans.length;i++){    
	    /*
	      for (int w = 1; w < count + 1;w++){
	      ans[i] = w;
	      }*/
	    if (count == n){
		return ans;
	    }
	    count += 1;
	}
	return ans;
    }
}
