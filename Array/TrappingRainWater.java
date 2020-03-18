package Array;

public class TrappingRainWater {
    public int trap(int[] height) {
        int water =0;
        int l= height.length;
        if(l==0){
            return water;
        }
        int[] left = new int[l];
        int[] right = new int[l];
        left[0]=height[0];

        for(int i=1;i<l;i++){
            left[i]= Math.max(left[i-1],height[i]);
        }
        right[l-1]=height[l-1];
        for(int i=l-2;i>=0;i--){
            right[i]=Math.max(right[i + 1], height[i]);
        }

        for(int i=0;i<l;i++){
            water+= Math.min(left[i], right[i])-height[i];
        }

        return water;
    }
}
