

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;
import java.util.Map;
import java.util.Arrays;
class Hashing_Basic{
    //optimal
    public void occurrence(int[] arr, int queries) {
        Scanner sc = new Scanner(System.in);
        int k;
        Map<Integer, Integer> hash=new HashMap<Integer, Integer>();
        for (int i=0; i<arr.length; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i], 0)+1);
        }
        for (int i=0; i<queries; i++) {
            System.err.println("Enter the query:");
            k=sc.nextInt();
            System.err.println("occurence of the querie is :"+hash.get(k));
        }
    }
    //optimal
    public void highest_occurence(int[] arr) {
        Map<Integer, Integer> map=new HashMap<>();
        int element=0; 
        int max_element=0; 
        int count=0;
        int max_count=0;
        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            element=entry.getKey();
            count=entry.getValue();
            if (count>max_count) {
                max_count=count; 
                max_element=element;
            }
        }
        System.err.println("Max element is : " + max_element + "\nMax count is : " + max_count);

    }
}
class Array_concept_easy {
    public void largest(int[] arr) {
        int largest=arr[0];
        for (int i=1; i<arr.length; i++) {
		    if (arr[i]>largest) {
		        largest=arr[i];
		    }
		}
		System.out.println(largest);
		
    }
    //brute
    public int second_largest(int[] arr) {
        if (arr.length<2){
            return -1;
        }
        Arrays.sort(arr);
        int i=2;
        while (i<arr.length) {
            if (arr[arr.length-i]!=arr[arr.length-1]) {
                return arr[arr.length-i];
            }
            i++;
        }
        return -1;
    }
    //better approach
    public int sl(int[] arr) {
        int largest=arr[0];
        int second_largest=-1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i]>largest) {
                second_largest=largest;
                largest=arr[i];
            }  
        }
        for (int i=1; i<arr.length; i++) {
            if (arr[i]<largest && arr[i]>second_largest) {
                second_largest=arr[i];
            }
        }
        return second_largest;
    }
    //brute approach
    public boolean sort_array_check(int[] arr) {
        int found = 1; 
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++){
                if (arr[i]>arr[j]) {
                    found=0;
                }
            }     
        }
        if (found == 0) {
            return false;
        }
        return true;
        
    }
    //better approach
    public boolean sort_array_check_better(int[] arr) {
        boolean found = true;
        for (int i = 1; i<arr.length; i++){
            if (arr[i]<arr[i-1]) {
                found=false;
            }
        }
        return found;

     }
    //brute approach
    public int remove_duplicate (int[] arr) {
        int n=arr.length;//5

        for (int i=0; i<n-1; i++) {
            //1,1,1,2,3
            for (int j=i+1; j<n; j++) {
                if (arr[i]==arr[j]) {//3 to 6
                    for (int k=j; k<n-1; k++) {
                        arr[k]=arr[k+1]; 
                    }
                    n--;
                    j--;
                }
            }
        }
        System.err.println("Total number of unique elements are:"+n);
        for (int i=0; i<n; i++) {

            System.err.println(arr[i]);
        }
        return 0;
     }
    //better approach
    public int remove_duplicate_better(int[] arr) {
        int p=0;

        
        for (int i=1; i<arr.length; i++) {
            if (arr[i]!=arr[p]) {
                p++;
                arr[p]=arr[i];
               
            }
        }
        System.err.println("arry");
        for (int j=0; j<p+1; j++) {
            System.err.println(arr[j]);
        }
        return 0;
     }  
    //better approach 
    public int rotate_array_left(int[] arr) {
        Scanner sc= new Scanner(System.in);
        System.err.println("how many times you want to rotate");
        int n=sc.nextInt();
        int temp=0; 
        int x=0;
        int z=n%arr.length;

        //Reverse the array
        for (int i=0; i<arr.length/2; i++) {
            temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        //Reverse the first z element array
        for (int j=1; j<z; j++) {
            temp=arr[j-1];
            arr[j-1]=arr[z-j];
            arr[z-j]=temp;
        }
        //reverse the remaining array
        for (int i=0; i<arr.length; i++) {
            temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        
        for (int j=0; j<arr.length; j++) {
            System.err.println(arr[j]);
        }
        return 0;
     }
    //better approach
    public void move_zero_end(int[] arr) {
        int j=-1;
        //find the first zero
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==0) {
                j=i;
                break;
            }
        }

        //return -1 if no zero is present
        if (j==-1) {
            System.err.println("No zero is present:" + j);
        }

        //start from next index of first zero and swap the elements
        for (int i=j+1; i<arr.length; i++) {
            if (arr[i]!=0) {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }

        for (int i=0; i<arr.length; i++) {
            System.err.println(arr[i]);
        }
    }
    //approach using map
    public void union_hashmap(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> map=new HashMap<>();
        for (int i=0; i<arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
        }
        for (int i=0; i<arr2.length; i++) {
            map.put(arr2[i], map.getOrDefault(arr2[i], 0)+1);
        }
        System.err.println(map);
            
    }
    //approach using hashset
    public void union_hashset(int[] arr1, int[] arr2) {
        HashSet set=new HashSet<>();
        for (int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.err.println(set);
    }
    //optimal approach using two pointer method
    public void union_two_pointers(int[] arr1, int[] arr2) {
        int n=arr1.length, m=arr2.length; 
        int[] arr3=new int[n+m]; 
        int i=0, j=0, k=0; 
        while (i<n && j<m) {
            if (arr1[i]<arr2[j]) {
                arr3[k]=arr1[i];
                i++;
            }
            else if (arr2[j]<arr1[i]){
                arr3[k]=arr2[j];
                j++;
            }
            else {
                arr3[k]=arr1[i];
                i++;
                j++;
            }
            k++;
        }

        while (i<n) {
            arr3[k]=arr1[i];
            i++;
            k++;
        }
        while (j<m) {
            arr3[k]=arr2[j];
            j++;
            k++;
        }
        if (i>j) {
            for (int p=0; p<i; p++) {
            System.err.println(arr3[p]);
        }
        }
        else {
            for (int p=0; p<j; p++) {
            System.err.println(arr3[p]);
        }
        }
        
    }
    //brute approach
    public void missing_numb(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for (int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }
        System.err.println(set);
        int element=-1; 
        for (int j=1; j<=arr.length; j++) {
            System.err.println(set.contains(j));
            if (!set.contains(j)) {
                element=j;
                break;
            }
        }
        System.err.println("The missing element is:" + element );
    }
    //better approach
    public void missing_numb_better(int[] arr) {
        int n=arr.length+1;
        int sum=0;
        for (int i=0; i<arr.length; i++) {
            sum+=arr[i];
        }
        int exp_sum=n*(n+1)/2;
        System.err.println("Missing number is:"+(exp_sum-sum));

    }
    //brute approach
    public void max_consecutive(int[] arr) {
        int count1=0;
        int count0=0; 
        int lastcount1=0;
        int lastcount0=0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==0) {
                count0++;
                for (int j=i+1; j<arr.length; j++) {
                    if (arr[j]==0) {
                        count0++;
                    }
                    else { 
                        i=j-1;
                        break;
                    }   
                }
                if (lastcount0==0) {
                            lastcount0=count0;
                        }
                else {
                    if (count0>lastcount0) {
                        lastcount0=count0;
                    }
                }
                count0=0;
            }
            else {
                count1++;
                for (int j=i+1; j<arr.length; j++) {
                    if (arr[j]==1) {
                        count1++;
                    }
                    else {
                        i=j-1;
                        break;
                    }
                }
                if (lastcount1==0) {
                    lastcount1=count1;
                }
                else {
                    if (count1>lastcount1) {
                        lastcount1=count1;
                    }
                }
                count1=0;
            }
        }
        if (lastcount0>lastcount1) {
            System.err.println("count of consecutive 0 is greater:"+lastcount0);
        }
        else if(lastcount0<lastcount1) {
            System.err.println("coutn of consecutive 1 is greater:"+lastcount1);
        }
        else {
            System.err.println("both 0 and 1 consecutive are equal:"+lastcount1);
        }
    }
    //better approach
    public void max_consecutive_better(int[] arr) {
        int count=0;
        int max=0;
        for (int x: arr) {
            if (x==1) {
                count++;
            }
            else {
                max=Math.max(max, count);
                count=0;
            }
        }
        max = Math.max(max, count);
        int count0=0;
        int max0=0;
        for (int x:arr) {
            if (x==0) {
                count0++;
            }
            else{
                max0=Math.max(max0, count0);
                count0=0;
            }
        }
        max0 = Math.max(max0, count0);
        if (max0>max) {
            System.err.println("max consecutive numb is 0 :"+max0);
        }
        else if (max0<max){
            System.err.println("max consecutive numbis 1 :"+max);
        }
        else{
            System.err.println("Both consecutive are same:"+max);
        }
    }
    //brute force approach
    public void two_sum(int[] arr, int target) {
        int left=0, right=0; 
        boolean found=false;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length-1; j++) {
                if (arr[i]+arr[j]==target) {
                    left=i; 
                    right=j;
                    found=true;
                    break;
                }
            }
        }
        if (found==true) {
            System.err.println("The answer is “YES” for first variant");
            System.err.println("for second variant output will be : ["+left+","+right+"]");
        }
    }
    //better approach
    public void two_sum_better(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
        int complement = target - arr[i];

        if (map.containsKey(complement)) {
            System.out.println("YES");
            System.out.println("{" + map.get(complement) + "," + i + "}");
            return;
        }

        map.put(arr[i], i);
    }

    System.out.println("NO");
}
    //optimal approach
    public void two_sum_optimal(int[] arr, int target) {
        int n=arr.length;
        int left=0,right=n-1;
        int[][] num=new int[n][2];
        for (int i=0; i<n; i++) {
            num[i][0]=arr[i];
            num[i][1]=i;
        }
        Arrays.sort(num, (a,b) -> Integer.compare(a[0],b[0]));
        while (left<right) {
            int sum=num[left][0]+num[right][0];
            if (sum==target) {
                System.err.println("yes");
                System.err.println("hashing approach is better for the indices");
                return;
            }
            else if (sum<target) {
                left++;
            }
            else {
                right--;
            }
        }
        System.err.println("NO");
        System.err.println("hashing approach is better for the indices");
        return;
    }
    //better approach
    public void majority_element(int[] arr) {
        int hl=arr.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (entry.getValue()>hl) {
                System.err.println(entry.getKey());
                break;
            }
        }
    }
    //optimal approach
    public void majority_element_optimal(int[] arr) {
        int n=arr.length;
        int cnt=0; 
        int ele=0;
        for (int i=0; i<n; i++) {
            if (cnt==0) {
                cnt=1;
                ele=arr[i];
            }
            else if (ele==arr[i]) {
                cnt++;
            }
            else {
                cnt--;
            }
        }
        int cnt1=0;
        for (int i=0; i<n; i++) {
            if (arr[i]==ele) {
                cnt1++;
            }
        }
        if (cnt1>n/2) {
            System.err.println(ele);
            return;
        }
        System.err.println(-1);
    }

}
class Array_concept_medium {
    //better
    public int freq_check(int[] arr) {
        int n = arr.length;
        int maxi = arr[0];
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        int[] hash = new int[maxi + 1];

        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }
        return -1; 
    }
    //optimal
    public void freq_check_optimal(int[] arr) {
        int xor=0;
        for (int e:arr) {
            xor^=e;
        }
        System.err.println("The least count number is :"+xor);
    }
    //brute
    public void longest_subarray(int[] arr) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the sum value (k): ");
        int k = sc.nextInt();

        boolean found = false;

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;
            arr1.clear();

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];
                arr1.add(arr[j]);

                if (sum == k) {

                    found = true;

                    if (arr1.size() > arr2.size()) {
                        arr2.clear();
                        arr2.addAll(arr1);
                    }

                    break;
                }
            }
        }

        if (found) {
            System.out.println("Longest subarray: " + arr2);
            System.out.println("Length: " + arr2.size());
        } else {
            System.out.println("No subarray found.");
        }
       

    }
    //better approach
    public int longest_subarray_better(int[] arr, int k) {
         HashMap<Long, Integer> preSumMap = new HashMap<>();

        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            long rem = sum - k;

            if (preSumMap.containsKey(rem)) {

                int len = i - preSumMap.get(rem);

                maxLen = Math.max(maxLen, len);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
    //sliding window approach
    public int longest_subarray_optimal(int[] nums, int k) {
        int n=nums.length;
        int left=0, right=0; 
        int max_len=0; 
        int sum=nums[0];
        while (right<n) {
            while (left<=right && sum>k) {
                sum-=nums[left];
                left++;
            }
            if (sum==k) {
                max_len=Math.max(max_len, right-left+1);
            }
            right++;
            if (right<n) {
                sum+=nums[right];
            }
        }
        return max_len;
    }
    //optimal approach    
    public void sortZeroOneTwo(int[] arr) {
        int low=0, mid=0, high=arr.length-1;
        while (mid<=high) {
            if (arr[mid]==0) {
                int temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;
                mid++;
            }
            else if (arr[mid]==1) {
                mid++;
            }
            else {
                int temp=arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
            }
        }
        for (int i=0; i<arr.length; i++) {
            System.err.println(arr[i]);
        }
    }
    //brute approach
    public void kandence_algorithm(int[] arr, int k) {
        int left=0, right=0;
        int cnt=0, max_cnt=0;
        int sum=0;
        int temp=0;
        while (left<=right) {
            sum+=arr[right];
            cnt++;
            if (sum==k) {
                sum-=arr[left];
                if (cnt>max_cnt) {
                    max_cnt=cnt;
                    temp=left;
                }
                left++;
                cnt--;
            }
            else if (sum>k) {
                sum-=arr[left];
                left++;
                cnt--;
            }
            right++;
            if (right==arr.length-1) {
                break;
            }
        }
        for (int i=temp; i<max_cnt; i++) {
            System.err.println(arr[i]);
        }
    }

}


public class DSA
{   
        public static void main(String[] args) {
        Array_concept_medium ap=new Array_concept_medium();
        int[] arr = {2, 3, 5, -2, 7, -4};
        int k=15;
        ap.kandence_algorithm(arr, k);
	}
}