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

    public int[] seriesUp(int n) {
	int[] ans = new int[n*(n + 1)/2];
	int count = 0;
	int k = 1;  
	for (int i = 0; i < ans.length;i++){    
	    ans[i] = k;
	    k += 1;
	    if (i == count){
		count = count + k;
		k = 1;
	    }  
	}
	return ans;
    }
    
    
    //not working for all tests
    public int maxMirror(int[] nums) {
	int newCount = 0;
	int oldCount = 0;
	int front;
	int back;
	for (int i = 0; i < nums.length;i++){
	    front=nums[i];
	    back=nums[nums.length - (i + 1)];
	    if (front == back){
		newCount += 1;            
	    } else {
		if (newCount > oldCount){
		    oldCount = newCount;            
		}
		newCount = 0;
           
	    }
	}
	if (newCount > oldCount){
	    oldCount = newCount;
	}
	return oldCount;
    }
    
    
}
