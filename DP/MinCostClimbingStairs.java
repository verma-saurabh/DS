package DP;

public class MinCostClimbingStairs {
/*
* https://www.revolvy.com/page/Dynamic-Programming-%7C%7C-leetcode-746.-Min-Cost-Climbing-Stairs%7C%7CSolving-DP-problems-through-recursion?smv=cTmUiwTw_7k&stype=topics&cmd=list
* */
    public int minCostClimbingStairs(int[] cost) {
        int l=cost.length;
        if(l<=1){
            return 0;
        }

        return Math.min(recursion(cost,1),recursion(cost,0));

    }

    public int recursion(int[] cost, int x){
        if(x>=cost.length){
            return 0;
        }
        int k= Math.min(recursion(cost,x+1),recursion(cost,x+2));
        return k+cost[x];
    }
}
