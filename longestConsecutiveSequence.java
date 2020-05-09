import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] res = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        // -1, -1, 0, 1, 3, 4, 5, 6, 7, 8, 9
        System.out.println(longestConsecutive(res));
    }
        public static int longestConsecutive(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;
            if(nums.length == 1)
                return 1;
            nums = Arrays. stream(nums). sorted(). toArray();
            int base = 0;
            List<List<Integer>> group = new ArrayList<>();
            List<Integer> ls = new ArrayList<>();
            for(int i=0, len = nums.length; i<len-1; ++i){
                int current = nums[i];
                if(nums[i+1] == current){
                    if(i==0 || !ls.contains(current))
                     ls.add(current);
                } else {
                    if(nums[i+1] - current == 1){
                        if(i==0)
                            ls.add(nums[0]);
                        ls.add(nums[i+1]);
                    } else {
                        base = nums[i+1];
                        ls = new ArrayList<>();
                        ls.add(base);
                    }
                }
                if(group.isEmpty()){
                    group.add(ls);
                }else{
                    if(group.get(0).size() < ls.size()){
                        group.remove(0);
                        group.add(ls);
                    }
                }
            }
            return group.get(0).size();
        }
}
